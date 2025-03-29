package com.scm.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.demo.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

    // Custom query methods can be defined here if needed
    // extra methods db related operations
    // custom finder methods

    Optional<User> findByEmail(String email);
}
