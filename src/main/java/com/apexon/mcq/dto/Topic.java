package com.apexon.mcq.dto;

import lombok.Data;

import java.util.List;

@Data
public class Topic {
    private String name;                        // e.g., "Collections", "OOPs"
    private List<DifficultyLevel> difficulties;
}
