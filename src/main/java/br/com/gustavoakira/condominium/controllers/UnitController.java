package br.com.gustavoakira.condominium.controllers;

import br.com.gustavoakira.condominium.models.Unit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UnitController {
    @GetMapping("units")
    public List<Unit> getAllUnitsByClient(){
        return null;
    }
}
