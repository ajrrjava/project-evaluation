package com.strateknia.evaluation.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    @Column(name="project_name")
    private final String projectName;

    @Column(name="company")
    private final String company;

    @Column(name="industry")
    private final String industry;

    @Column(name="type")
    private final Integer type;

    @Column(name="amount")
    private final Double amount;

//    @Column(name="year")
//    private final Integer year;

    @Column(name="employees")
    private final Integer employees;

    @Column(name="sales")
    private final Double sales;

    @JsonInclude
    @Transient
    private Facts facts;
}
