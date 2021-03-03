package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.exceptions.ForbiddenAccess;
import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;
import br.com.gustavoakira.condominium.services.interfaces.AnimalService;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import br.com.gustavoakira.condominium.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ClientService clientService;

    private Client getAuthenticated(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientService.getClientByEmail(email);
    }

    @GetMapping("animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAllAnimalsByClient(){
        return service.getAnimals(getAuthenticated());
    }

    @PostMapping("animal/unit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewAnimal(@RequestBody Animal animal, @PathVariable Long id){
        Unit unit = unitService.getUnit(id);
        if(unit.getClient() == getAuthenticated()){
            throw new ForbiddenAccess();
        }
        animal.setClient(getAuthenticated());
        animal.setUnit(unit);
        service.createAnimal(animal);
        return;
    }

    @PutMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnimal(@RequestBody Animal animal,@PathVariable Long id){
        if( service.getAnimal(id).getClient() != getAuthenticated()){
            throw new ForbiddenAccess();
        }
        service.updateAnimal(id,animal);
    }


    @PutMapping("animal/{id}/unit/{unitId}")
    public void updateAnimalUnit(@PathVariable("id") Long id, @PathVariable("unitId") Long unitId){
        Animal animal = service.getAnimal(id);
        Unit unit = unitService.getUnit(unitId);
        if(unit.getClient() != getAuthenticated()){
            throw new ForbiddenAccess();
        }
        animal.setUnit(unit);
        service.updateAnimal(id,animal);
    }

    @DeleteMapping("animal/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAnimal(@PathVariable Long id){
        if( service.getAnimal(id).getClient() != getAuthenticated()){
            throw new ForbiddenAccess();
        }
        service.removeAnimal(id);
    }
}
