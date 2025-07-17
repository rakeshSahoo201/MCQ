package com.apexon.mcq.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContextArea {
    private String name;                // e.g., "Core Java", "Spring Boot"
    private List<Topic> topics;
}
