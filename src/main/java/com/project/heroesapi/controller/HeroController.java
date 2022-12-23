package com.project.heroesapi.controller;

import com.project.heroesapi.model.Hero;
import com.project.heroesapi.model.Power;
import com.project.heroesapi.repository.HeroRepo;
import com.project.heroesapi.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHero(@PathVariable(value = "id") Long id){
        Hero hero = heroRepo.findById(id).orElse(null);
        if(hero == null){
            return ResponseHandler.generateResponse("O objeto a ser excluído não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            heroRepo.delete(hero);
            return ResponseHandler.generateResponse("O objeto foi excluído com sucesso",
                    HttpStatus.OK, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHero(@PathVariable(value = "id") Long id, @RequestBody Hero heroDetails){
        Hero hero = heroRepo.findById(id).orElse(null);
        if(hero == null){
            return ResponseHandler.generateResponse("O objeto a ser atualizado não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            hero.updateHeroObject(heroDetails);
            Hero updatedHero = heroRepo.save(hero);
            return ResponseHandler.generateResponse("O objeto foi atualizado com sucesso.",
                    HttpStatus.OK, updatedHero);
        }


    }

}
