package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Debt;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import br.com.gustavoakira.condominium.services.interfaces.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DebtController {
    @Autowired
    private DebtService service;

    @Autowired
    private ClientService clientService;

    @GetMapping("debts")
    public ResponseEntity<List<Debt>> getAllDebts(){
        return ResponseEntity.ok(service.getDebts(getAuthenticated()));
    }

    @PostMapping("debt/unit/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Void> saveDebt(@RequestBody Debt debt){
        service.saveNewDebt(debt);
        return ResponseEntity.created(URI.create("")).build();
    }
    @PutMapping("debt/{id}/price/{newAmount}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Void> updateDebtAmount(@PathVariable("id") Long id, @PathVariable("newAmount") Double amount){
        Debt updated = service.getDebt(id);
        updated.setAmount(amount);
        service.updateDebt(id,updated);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("debt/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Void> removeDebt(@PathVariable Long id){
        service.removeDebt(id);
        return ResponseEntity.noContent().build();
    }

    private Client getAuthenticated(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientService.getClientByEmail(email);
    }
}
