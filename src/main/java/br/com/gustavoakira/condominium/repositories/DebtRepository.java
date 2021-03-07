package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt,Long> {
    @Query("SELECT d from Debt d where d.client = ?1")
    List<Debt> getDebtsByClient(Client client);
}
