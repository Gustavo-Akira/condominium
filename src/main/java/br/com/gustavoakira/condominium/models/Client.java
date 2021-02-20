package br.com.gustavoakira.condominium.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Data
public class Client implements UserDetails {
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

    @ManyToMany
    private List<Role> roles= new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
