package com.project.heroesapi.controller;

import com.project.heroesapi.model.PowerType;
import com.project.heroesapi.repository.PowerTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/powerTypes")
public class PowerTypeController {

    @Autowired
    private PowerTypeRepo powerTypeRepo;

    @GetMapping
    public List<PowerType> powerTypes(){
        return powerTypeRepo.findAll();
    }


    public PowerType addPowerType(@RequestBody PowerType pt){
        return powerTypeRepo.save(pt);
    }
}
