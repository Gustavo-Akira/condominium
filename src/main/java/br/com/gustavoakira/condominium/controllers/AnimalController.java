package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAllAnimalsByClient(@RequestBody Client client){
        return service.getAnimals(client);
    }

    @PostMapping("animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewAnimal(@RequestBody Animal animal){
        service.createAnimal(animal);
        return;
    }

    @PutMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnimal(@RequestBody Animal animal,@PathVariable Long id){
        service.updateAnimal(id,animal);
    }

    @DeleteMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAnimal(@PathVariable Long id){
        service.removeAnimal(id);
    }
}
