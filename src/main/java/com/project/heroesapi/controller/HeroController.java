package com.project.heroesapi.controller;

import com.project.heroesapi.model.Hero;
import com.project.heroesapi.repository.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroController {

    @Autowired
    private HeroRepo heroRepo;

    @GetMapping
    public List<Hero> getHeroes(){
        return heroRepo.findAll();
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero){
        return heroRepo.save(hero);
    }

}
