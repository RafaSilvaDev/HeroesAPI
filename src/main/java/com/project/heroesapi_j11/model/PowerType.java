package com.project.heroesapi_j11.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class PowerType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private long id;

    @Column(name = "type", nullable = false)
    private String type;
}
