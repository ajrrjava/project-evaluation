package com.strateknia.evaluation.common.entity;

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
@Table(name = "criteria")
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    @Column(name="type")
    private final Integer type;

    @Column(name="industry")
    private final String industry;

    @Column(name="min_amount")
    private final Double minAmount;

    @Column(name="max_amount")
    private final Double maxAmount;

    @Column(name="min_roi")
    private final Double minROI;

    @Column(name="max_roi")
    private final Double maxROI;
}
