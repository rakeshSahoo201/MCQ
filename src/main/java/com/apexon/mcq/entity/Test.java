package com.apexon.mcq.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testName;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<TestSection> sections;
}

