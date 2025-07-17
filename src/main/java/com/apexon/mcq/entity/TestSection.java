package com.apexon.mcq.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String knowledgeArea;
    private int numberOfQuestions;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}


