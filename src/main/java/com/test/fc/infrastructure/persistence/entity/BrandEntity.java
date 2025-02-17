package com.test.fc.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "brands")
@Getter
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}