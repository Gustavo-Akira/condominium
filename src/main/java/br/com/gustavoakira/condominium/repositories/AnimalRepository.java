package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
