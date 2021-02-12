package br.com.gustavoakira.condominium.services.impl;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.repositories.ClientRepository;
import br.com.gustavoakira.condominium.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public void createClient(Client client) {
        repository.save(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        getClient(id);
        client.setId(id);
        repository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }
}
