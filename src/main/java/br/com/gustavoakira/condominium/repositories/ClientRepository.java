package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
