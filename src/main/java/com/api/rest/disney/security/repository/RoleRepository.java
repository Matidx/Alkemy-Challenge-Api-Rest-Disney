package com.api.rest.disney.security.repository;

import com.api.rest.disney.security.entities.Role;
import com.api.rest.disney.security.enums.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
    @Override
    Optional<Role> findById(Integer integer);
}
