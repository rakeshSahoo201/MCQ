package com.apexon.mcq.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="options")
@Data
public class Option {
        @EmbeddedId
        private OptionId id;

        private boolean isCorrect;

        private String explanation;

        private String description;

        @ManyToOne
        @MapsId("questionId")
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")
        private Question question;
}
