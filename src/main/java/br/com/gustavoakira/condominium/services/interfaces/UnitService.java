package br.com.gustavoakira.condominium.services.interfaces;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;

import java.util.List;

public interface UnitService {
    void createUnit(Unit unit);
    void updateUnit(Long id,Unit unit);
    Unit getUnit(Long id);
    List<Unit> getUnits(Client client);
    void removeUnit(Long id);
}
