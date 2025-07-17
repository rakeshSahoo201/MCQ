package com.apexon.mcq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "Question", "questionStatement", "options" })
public class QuestionResponseDto {
    @JsonProperty("Question")
    private Long questionNumber;

    private String questionStatement;

    private Map<String, String> options;
}
