package br.com.gustavoakira.condominium.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long number;

    @OneToMany(mappedBy = "client")
    private List<Unit> units = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Vehicle> vehicles = new ArrayList<>();
}
