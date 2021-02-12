package br.com.gustavoakira.condominium.models;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Unit unit;
}
