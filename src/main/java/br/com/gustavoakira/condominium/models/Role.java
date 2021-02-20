package br.com.gustavoakira.condominium.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;

    @ManyToMany
    private List<Client> clients = new ArrayList<>();

    @Override
    public String getAuthority() {
        return this.role;
    }

}
