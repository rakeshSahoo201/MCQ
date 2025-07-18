package com.apexon.mcq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicWiseQuestionsDto {
    private String topicName;
    private String difficultyLevel;
    private List<QuestionDto> questions;
}
