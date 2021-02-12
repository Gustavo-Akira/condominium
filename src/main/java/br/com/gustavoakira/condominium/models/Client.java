package br.com.gustavoakira.condominium.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Long number;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Unit> units = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Vehicle> vehicles = new ArrayList<>();
}
