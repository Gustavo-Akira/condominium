package br.com.gustavoakira.condominium.models;

import br.com.gustavoakira.condominium.models.enums.VehicleType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
