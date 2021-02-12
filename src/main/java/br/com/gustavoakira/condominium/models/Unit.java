package br.com.gustavoakira.condominium.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "unit")
    private List<Animal> animals = new ArrayList<>();
}
