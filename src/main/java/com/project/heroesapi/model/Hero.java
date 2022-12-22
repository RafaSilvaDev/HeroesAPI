package com.project.heroesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hero {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "armour")
    private Integer armour;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "vitality")
    private Integer vitality;

    @Column(name = "history")
    private String history;

    @ManyToMany
    @JoinTable(name = "hero_power", joinColumns = @JoinColumn(name = "hero_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "power_id", referencedColumnName = "id"))
    private List<Power> powers;
}
