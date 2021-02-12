package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Animal;
import br.com.gustavoakira.condominium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    @Query("SELECT a from Animal a where a.client=?1")
    List<Animal> getAnimalsByClient(Client client);
}
