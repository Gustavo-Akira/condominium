package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1")
public class ClientController {
    @Autowired
    private ClientService service;
    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        return ResponseEntity.ok(service.getClient(id));
    }

    @PostMapping("client")
    public ResponseEntity<Void> saveClient(@RequestBody Client client){
        service.createClient(client);
        return ResponseEntity.created(URI.create(String.format("/client/%s",client.getName()))).build();
    }

    @PutMapping("client/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable Long id, @RequestBody Client client){
        service.updateClient(id,client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<Void> removeClient(@PathVariable Long id){
        service.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
