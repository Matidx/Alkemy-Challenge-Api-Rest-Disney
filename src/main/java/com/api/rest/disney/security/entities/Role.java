package com.api.rest.disney.security.entities;

import com.api.rest.disney.security.enums.RoleList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleList roleName;

    public Role() {
    }

    public Role( RoleList roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleList getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleList roleName) {
        this.roleName = roleName;
    }
}
