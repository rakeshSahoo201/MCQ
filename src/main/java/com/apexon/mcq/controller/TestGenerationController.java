package com.apexon.mcq.controller;

import com.apexon.mcq.dto.TestGenerationRequest;
import com.apexon.mcq.dto.TestGenerationResponse;
import com.apexon.mcq.service.TestGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test-generator")
public class TestGenerationController {

    @Autowired
    private TestGeneratorService testGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<TestGenerationResponse> generateTest(@RequestBody TestGenerationRequest requestDto) {
        TestGenerationResponse response = testGeneratorService.generateTest(requestDto);
        return ResponseEntity.ok(response);
    }

}
