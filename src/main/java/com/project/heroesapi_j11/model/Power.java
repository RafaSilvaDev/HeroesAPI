package com.project.heroesapi_j11.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Power {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "damage")
    private Integer damage;

    @OneToOne  @JoinColumn(name = "type", nullable = false)
    private PowerType type;
}
