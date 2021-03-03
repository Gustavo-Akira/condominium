package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.exceptions.ForbiddenAccess;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Vehicle;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import br.com.gustavoakira.condominium.services.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @Autowired
    private ClientService clientService;

    @GetMapping("vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles(){
        return ResponseEntity.ok(service.getVehicles(getAuthenticated()));
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicle(Long id){
        if(checkingOwner(id)){
            throw new ForbiddenAccess();
        }
        return ResponseEntity.ok(service.getVehicle(id));
    }

    @PostMapping("vehicle")
    public ResponseEntity<Void> saveNewVehicle(@RequestBody Vehicle vehicle){
        vehicle.setClient(getAuthenticated());
        service.createVehicle(vehicle);
        return ResponseEntity.created(URI.create("http")).build();
    }

    @PutMapping("vehicle/{id}")
    public ResponseEntity<Void> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        if(checkingOwner(id)){
            throw new ForbiddenAccess();
        }
        service.updateVehicle(id,vehicle);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("vehicle/{id}")
    public ResponseEntity<Void> removeVehicle(@PathVariable Long id){
        if(checkingOwner(id)){
            throw new ForbiddenAccess();
        }
        service.removeVehicle(id);
        return ResponseEntity.noContent().build();
    }

    private Client getAuthenticated(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientService.getClientByEmail(email);
    }

    private boolean checkingOwner(Long id){
        return service.getVehicle(id).getClient() == getAuthenticated();
    }
}
