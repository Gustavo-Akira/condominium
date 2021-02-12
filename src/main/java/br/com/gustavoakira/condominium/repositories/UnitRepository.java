package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {
    List<Unit> getUnitsByClient(Client client);
}
