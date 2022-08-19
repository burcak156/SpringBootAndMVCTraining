package com.training.repositories;

import com.training.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);
}