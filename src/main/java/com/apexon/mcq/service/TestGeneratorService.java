package com.apexon.mcq.service;

import com.apexon.mcq.dto.*;
import com.apexon.mcq.repository.TestGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TestGeneratorService {

    @Autowired
    private TestGeneratorRepository testGenRepository;

    public TestGenerationResponse generateTest(TestGenerationRequest request) {
        List<AreaWiseQuestionsDto> areaWiseList = new ArrayList<>();
        int globalQuestionNumber = 1;

        for (ContextArea area : request.getContextAreas()) {
            String skillName = area.getName();
            List<TopicWiseQuestionsDto> topicDtos = new ArrayList<>();

            for (Topic topic : area.getTopics()) {
                String topicName = topic.getName();

                for (DifficultyLevel diff : topic.getDifficulties()) {
                    List<QuestionOptionProjection> projections = testGenRepository
                            .findQuestionsBySkillNameAndAreaAndDifficulty(
                                    skillName, diff.getLevel(), topicName // skill, difficulty, area(topic)
                            );

                    Map<String, List<QuestionOptionProjection>> groupedQuestions =
                            projections.stream()
                                    .collect(Collectors.groupingBy(QuestionOptionProjection::getQuestionStatement));

                    List<Map.Entry<String, List<QuestionOptionProjection>>> limitedQuestions =
                            groupedQuestions.entrySet().stream()
                                    .limit(diff.getNumberOfQuestions())
                                    .toList();

                    List<QuestionDto> questionDtos = new ArrayList<>();

                    for (Map.Entry<String, List<QuestionOptionProjection>> entry : limitedQuestions) {
                        QuestionDto dto = new QuestionDto();
                        dto.setQuestionNumber(globalQuestionNumber++);
                        dto.setQuestionStatement(entry.getKey());
                        dto.setOptions(mapOptions(entry.getValue()));
                        questionDtos.add(dto);
                    }

                    if (!questionDtos.isEmpty()) {
                        topicDtos.add(new TopicWiseQuestionsDto(topicName, diff.getLevel(), questionDtos));
                    }
                }
            }

            if (!topicDtos.isEmpty()) {
                areaWiseList.add(new AreaWiseQuestionsDto(skillName, topicDtos));
            }
        }

        return new TestGenerationResponse(request.getTemplateName(), areaWiseList);
    }

    private Map<String, String> mapOptions(List<QuestionOptionProjection> options) {
        Map<String, String> optionMap = new LinkedHashMap<>();
        String[] keys = {"OptionA", "OptionB", "OptionC", "OptionD"};
        for (int i = 0; i < options.size() && i < keys.length; i++) {
            optionMap.put(keys[i], options.get(i).getDescription());
        }
        return optionMap;
    }

}
