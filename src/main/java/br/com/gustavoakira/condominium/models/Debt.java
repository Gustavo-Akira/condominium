package br.com.gustavoakira.condominium.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    private Double amount;

    @OneToOne
    private Unit unit;

    @OneToOne
    private Client client;
}
