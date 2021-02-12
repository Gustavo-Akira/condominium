package br.com.gustavoakira.condominium.models;

import br.com.gustavoakira.condominium.models.enums.VehicleType;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated
    private VehicleType type;

    @ManyToOne
    private Client client;
}
