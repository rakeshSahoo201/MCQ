package com.apexon.mcq.repository;

import com.apexon.mcq.dto.QuestionOptionProjection;
import com.apexon.mcq.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestGeneratorRepository extends JpaRepository<Question, Long> {

    @Query(
            value = "SELECT q.question_statement AS questionStatement, " +
                    "o.option_id AS optionId, " +
                    "o.description AS description " +
                    "FROM questions q " +
                    "JOIN options o ON q.question_id = o.question_id " +
                    "JOIN skills s ON q.skill_id = s.skill_id " +
                    "WHERE s.skill_name = :skillName " +
                    "AND q.difficulty = :difficulty " +
                    "AND q.area = :area " +
                    "ORDER BY q.question_id, o.option_id",
            nativeQuery = true
    )
    List<QuestionOptionProjection> findQuestionsBySkillNameAndAreaAndDifficulty(
            @Param("skillName") String skillName,
            @Param("difficulty") String difficulty,
            @Param("area") String area
    );
}
