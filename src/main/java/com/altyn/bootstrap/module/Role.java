package com.altyn.bootstrap.module;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;
    @Column(name = "role")
    private String role;

    public Role() {
    }

    @Override
    public String getAuthority() {

        return role;
    }

    public long getId() {
        return id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        if(role.equals("ROLE_USER")){
            return "USER";
        } else return "ADMIN";
    }
}
