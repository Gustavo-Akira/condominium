package br.com.gustavoakira.condominium.services.impl;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Vehicle;
import br.com.gustavoakira.condominium.services.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.gustavoakira.condominium.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateVehicle(Long id, Vehicle vehicle) {
        Vehicle old = getVehicle(id);
        vehicle.setId(id);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void removeVehicle(Long id) {
        getVehicle(id);
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getVehicles(Client client) {
        return vehicleRepository.getVehiclesByClient(client);
    }
}
