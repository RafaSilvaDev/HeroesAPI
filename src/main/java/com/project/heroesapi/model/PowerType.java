package com.project.heroesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PowerType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private long id;

    @Column(name = "type", nullable = false)
    private String type;
}
