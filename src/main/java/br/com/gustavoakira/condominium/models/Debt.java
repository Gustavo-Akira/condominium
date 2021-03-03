package br.com.gustavoakira.condominium.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    @OneToOne
    private Unit unit;

    @OneToOne
    private Client client;
}
