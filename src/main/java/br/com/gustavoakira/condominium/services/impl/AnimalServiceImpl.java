package br.com.gustavoakira.condominium.services.impl;

import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.gustavoakira.condominium.repositories.AnimalRepository;

import java.util.List;

public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Override
    public void createAnimal(Animal animal) {
        repository.save(animal);
    }

    @Override
    public void updateAnimal(Long id, Animal animal) {
        getAnimal(id);
        animal.setId(id);
        repository.save(animal);
    }

    @Override
    public Animal getAnimal(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Animal> getAnimals(Client client) {
        return null;
    }
}
