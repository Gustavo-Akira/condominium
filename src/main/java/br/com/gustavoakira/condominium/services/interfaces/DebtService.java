package br.com.gustavoakira.condominium.services.interfaces;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Debt;

import java.util.List;

public interface DebtService {
    Debt getDebt(Long id);
    List<Debt> getDebts(Client client);
    void saveNewDebt(Debt debt);
    void updateDebt(Long id, Debt debt);
    void removeDebt(Long id);
}
