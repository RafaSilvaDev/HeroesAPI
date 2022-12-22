package com.project.heroesapi.controller;

import com.project.heroesapi.model.Power;
import com.project.heroesapi.repository.PowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poderes")
public class PowerController {
    @Autowired
    private PowerRepo powerRepo;

    @GetMapping
    public List<Power> getPowers(){
        return powerRepo.findAll();
    }

    @PostMapping
    public Power addPower(@RequestBody Power power){
        return powerRepo.save(power);
    }
}
