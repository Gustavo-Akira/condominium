package br.com.gustavoakira.condominium.repositories;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query("SELECT v from Vehicle v where v.client= ?1")
    List<Vehicle> getVehiclesByClient(Client client);
}
