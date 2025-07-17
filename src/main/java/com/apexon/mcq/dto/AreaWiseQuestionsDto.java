package com.apexon.mcq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaWiseQuestionsDto {
    private String areaName;
    private List<TopicWiseQuestionsDto> topics;
}
