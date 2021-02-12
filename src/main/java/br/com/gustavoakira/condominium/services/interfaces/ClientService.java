package br.com.gustavoakira.condominium.services.interfaces;

import br.com.gustavoakira.condominium.models.Client;

import java.util.List;

public interface ClientService {
    void createClient(Client client);
    void updateClient(Long id, Client client);
    Client getClient(Long id);
    List<Client> getClients();
}
