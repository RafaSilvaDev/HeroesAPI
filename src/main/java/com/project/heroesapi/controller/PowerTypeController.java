package com.project.heroesapi.controller;

import com.project.heroesapi.model.PowerType;
import com.project.heroesapi.repository.PowerTypeRepo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tipospoder")
public class PowerTypeController {

    @Autowired
    private PowerTypeRepo powerTypeRepo;

    @GetMapping
    public List<PowerType> getPowerTypes(){
        return powerTypeRepo.findAll();
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public PowerType addPowerType(@RequestBody PowerType pt){
        return powerTypeRepo.save(pt);
    }

    /*

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePowerType(@PathVariable(value = "id") Long id)
            throws IllegalArgumentException {
                PowerType powerType = powerTypeRepo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("O tipo de poder não foi encontrado com este id: " + id));

                powerTypeRepo.delete(powerType);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePowerType(@PathVariable(value = "id") Long id){
        PowerType powerType = powerTypeRepo.findById(id).orElse(null);
        if(powerType == null){
            return new ResponseEntity<>("Tipo poder não encontrado.", HttpStatus.NOT_FOUND);
        }else{
            powerTypeRepo.delete(powerType);
            return new ResponseEntity<>("Tipo poder deletado.", HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PowerType> updatePowerType(@PathVariable(value = "id") Long id, @RequestBody PowerType powerTypeDetails)
            throws IllegalArgumentException {
        PowerType powerType = powerTypeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O tipo de poder não foi encontrado com este id: " + id));

        powerType.setType(powerTypeDetails.getType());
        final PowerType updatedPowerType = powerTypeRepo.save(powerType);
        return ResponseEntity.ok(updatedPowerType);
    }

}
