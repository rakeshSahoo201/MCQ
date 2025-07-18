package com.apexon.mcq.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class OptionId implements Serializable {

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "option_id")
    private Integer optionId;

}
