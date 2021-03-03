package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.exceptions.ForbiddenAccess;
import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import br.com.gustavoakira.condominium.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UnitController {
    @Autowired
    private UnitService service;

    @Autowired
    private ClientService clientService;

    private Client getAuthenticated(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientService.getClientByEmail(email);
    }
    @GetMapping("units")
    @ResponseStatus(HttpStatus.OK)
    public List<Unit> getAllUnitsByClient(){
        return service.getUnits(getAuthenticated());
    }

    @PostMapping("unit")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewUnit(@RequestBody Unit unit){
        unit.setClient(getAuthenticated());
        service.createUnit(unit);
    }

    @PutMapping("unit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUnit(@PathVariable Long id, @RequestBody Unit unit){
        if(service.getUnit(id).getClient() != getAuthenticated()){
            throw new ForbiddenAccess();
        }
        service.updateUnit(id,unit);
    }

    @DeleteMapping("unit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUnit(@PathVariable Long id){
        if(service.getUnit(id).getClient() != getAuthenticated()){
            throw new ForbiddenAccess();
        }
        service.removeUnit(id);
    }
}
