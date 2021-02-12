package br.com.gustavoakira.condominium.services.impl;

import br.com.gustavoakira.condominium.models.Client;
import br.com.gustavoakira.condominium.models.Unit;
import br.com.gustavoakira.condominium.repositories.UnitRepository;
import br.com.gustavoakira.condominium.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository repository;

    @Override
    public void createUnit(Unit unit){
        repository.save(unit);
    }

    @Override
    public void updateUnit(Long id, Unit unit) {
        getUnit(id);
        unit.setId(id);
        repository.save(unit);
    }

    @Override
    public Unit getUnit(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Unit> getUnits(Client client) {
        return repository.getUnitsByClient(client);
    }
}
