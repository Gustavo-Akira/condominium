package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c from Client c where c.email=?1")
    Client getClientByEmail(String email);
}
