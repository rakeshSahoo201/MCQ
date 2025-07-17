package com.apexon.mcq.dto;

import lombok.Data;

@Data
public class DifficultyLevel {
    private String level;                 // e.g., "easy", "medium", "hard"
    private int numberOfQuestions;
}
