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
@Table(name = "facts")
public class Facts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(name="roi")
    private final Double roi;

    @Column(name="npv")
    private final Double npv;

    @Column(name="payback")
    private final Double payback;
}
