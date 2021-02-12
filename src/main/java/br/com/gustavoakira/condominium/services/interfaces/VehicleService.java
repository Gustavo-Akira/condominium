package br.com.gustavoakira.condominium.services.interfaces;

import br.com.gustavoakira.condominium.models.Vehicle;

public interface VehicleService {
    void createVehicle(Vehicle vehicle);
    Vehicle getVehicle(Long id);
    void updateVehicle(Long id, Vehicle vehicle);
    void removeVehicle(Long id);
}
