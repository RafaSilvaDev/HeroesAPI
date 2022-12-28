package com.project.heroesapi.controller;
import com.project.heroesapi.model.PowerType;
import com.project.heroesapi.repository.PowerTypeRepo;
import com.project.heroesapi.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipospoder")
public class PowerTypeController {

    @Autowired
    private PowerTypeRepo powerTypeRepo;

    @GetMapping
    public List<PowerType> getPowerTypes(){
        return powerTypeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPowerType(@PathVariable(value = "id") Long id){
        PowerType powerType = powerTypeRepo.findById(id).orElse(null);
        if(powerType == null){
            return ResponseHandler.generateResponse("O objeto não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            return ResponseHandler.generateResponse("O objeto foi encontrado",
                    HttpStatus.OK, powerType);
        }
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public PowerType addPowerType(@RequestBody PowerType pt){
        return powerTypeRepo.save(pt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePowerType(@PathVariable(value = "id") Long id){
        PowerType powerType = powerTypeRepo.findById(id).orElse(null);
        if(powerType == null){
            return ResponseHandler.generateResponse("O objeto a ser excluído não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            powerTypeRepo.delete(powerType);
            return ResponseHandler.generateResponse("O objeto foi excluído com sucesso",
                    HttpStatus.OK, powerType);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePowerType(@PathVariable(value = "id") Long id, @RequestBody PowerType powerTypeDetails){
        PowerType powerType = powerTypeRepo.findById(id).orElse(null);
        if(powerType == null){
            return ResponseHandler.generateResponse("O objeto a ser atualizado não foi encontrado.",
                    HttpStatus.NOT_FOUND, null);
        }else{
            powerType.setType(powerTypeDetails.getType());
            PowerType updatedPowerType = powerTypeRepo.save(powerType);
            return ResponseHandler.generateResponse("O objeto foi atualizado com sucesso.",
                    HttpStatus.OK, updatedPowerType);
        }


    }

}
