package ru.kata.spring.boot_security.demo.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;

    public Role(Long l, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {

    }
    public Role(String name){
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;



}