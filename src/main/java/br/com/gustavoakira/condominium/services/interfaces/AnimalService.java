package br.com.gustavoakira.condominium.services.interfaces;

import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;

import java.util.List;

public interface AnimalService {
    void createAnimal(Animal animal);
    void updateAnimal(Long id,Animal animal);
    Animal getAnimal(Long id);
    List<Animal> getAnimals(Client client);
}
