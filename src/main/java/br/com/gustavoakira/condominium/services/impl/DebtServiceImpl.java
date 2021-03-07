package br.com.gustavoakira.condominium.services.impl;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Debt;
import br.com.gustavoakira.condominium.repositories.DebtRepository;
import br.com.gustavoakira.condominium.services.interfaces.DebtService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DebtServiceImpl implements DebtService {
    @Autowired
    private DebtRepository repository;

    @Override
    public Debt getDebt(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Debt> getDebts(Client client) {
        return repository.getDebtsByClient(client);
    }

    @Override
    public void saveNewDebt(Debt debt) {
        repository.save(debt);
    }

    @Override
    public void updateDebt(Long id, Debt debt) {
        Debt old = getDebt(id);
        debt.setId(id);
        repository.save(debt);
    }

    @Override
    public void removeDebt(Long id) {
        getDebt(id);
        repository.deleteById(id);
    }
}
