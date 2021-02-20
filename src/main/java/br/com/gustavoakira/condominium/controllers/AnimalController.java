package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;
import br.com.gustavoakira.condominium.services.interfaces.AnimalService;
import br.com.gustavoakira.condominium.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @Autowired
    private UnitService unitService;

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAllAnimalsByClient(){
        return null;
    }

    @PostMapping("animal/unit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewAnimal(@RequestBody Animal animal, @PathVariable Long id){
        Unit unit = unitService.getUnit(id);
        animal.setUnit(unit);
        service.createAnimal(animal);
        return;
    }

    @PutMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnimal(@RequestBody Animal animal,@PathVariable Long id){
        service.updateAnimal(id,animal);
    }


    @PutMapping("animal/{id}/unit/{unitId}")
    public void updateAnimalUnit(@PathVariable("id") Long id, @PathVariable("unitId") Long unitId){
        Animal animal = service.getAnimal(id);
        animal.setUnit(unitService.getUnit(unitId));
        service.updateAnimal(id,animal);
    }

    @DeleteMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAnimal(@PathVariable Long id){
        service.removeAnimal(id);
    }
}
