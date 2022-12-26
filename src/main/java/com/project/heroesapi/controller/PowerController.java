package com.project.heroesapi.controller;

import com.project.heroesapi.model.Hero;
import com.project.heroesapi.model.Power;
import com.project.heroesapi.model.PowerType;
import com.project.heroesapi.repository.PowerRepo;
import com.project.heroesapi.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPower(@PathVariable(value = "id") Long id){
        Power power = powerRepo.findById(id).orElse(null);
        if(power == null){
            return ResponseHandler.generateResponse("O objeto não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            return ResponseHandler.generateResponse("O objeto foi encontrado",
                    HttpStatus.OK, power);
        }
    }

    @PostMapping
    public Power addPower(@RequestBody Power power){
        return powerRepo.save(power);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePower(@PathVariable(value = "id") Long id){
        Power power = powerRepo.findById(id).orElse(null);
        if(power == null){
            return ResponseHandler.generateResponse("O objeto a ser excluído não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            powerRepo.delete(power);
            return ResponseHandler.generateResponse("O objeto foi excluído com sucesso",
                    HttpStatus.OK, power);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePower(@PathVariable(value = "id") Long id, @RequestBody Power powerDetails){
        Power power = powerRepo.findById(id).orElse(null);
        if(power == null){
            return ResponseHandler.generateResponse("O objeto a ser atualizado não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            power.setName(powerDetails.getName());
            power.setDamage(powerDetails.getDamage());
            power.setType(powerDetails.getType());
            Power updatedPower = powerRepo.save(power);
            return ResponseHandler.generateResponse("O objeto foi atualizado com sucesso.",
                    HttpStatus.OK, updatedPower);
        }


    }
}
