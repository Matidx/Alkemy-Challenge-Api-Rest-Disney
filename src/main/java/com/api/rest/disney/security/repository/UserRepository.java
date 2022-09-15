package com.api.rest.disney.security.repository;

import java.util.Optional;

import com.api.rest.disney.security.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);

}
