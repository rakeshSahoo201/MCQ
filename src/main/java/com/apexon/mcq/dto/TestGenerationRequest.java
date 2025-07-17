package com.apexon.mcq.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestGenerationRequest {
    private String templateName;
    private List<ContextArea> contextAreas;
}
