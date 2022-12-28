package com.project.heroesapi_j11.model;

import javax.persistence.*;
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

    public void updateHeroObject(Hero otherHero){
        this.setName(otherHero.getName());
        this.setNickname(otherHero.getNickname());
        this.setArmour(otherHero.getArmour());
        this.setSpeed(otherHero.getSpeed());
        this.setVitality(otherHero.getVitality());
        this.setHistory(otherHero.getHistory());
        this.setPowers(otherHero.getPowers());
    }
}
