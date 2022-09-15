package com.api.rest.disney.security.service;

import javax.transaction.Transactional;

import com.api.rest.disney.security.entities.Role;
import com.api.rest.disney.security.repository.RoleRepository;
import com.api.rest.disney.security.enums.RoleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }

    public Optional<Role> findById(Integer integer){
        return roleRepository.findById(integer);
    }
}