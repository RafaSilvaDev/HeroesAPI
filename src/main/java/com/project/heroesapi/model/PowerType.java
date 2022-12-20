package com.project.heroesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PowerType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String type;
}
