package com.tientt.springmvc.repository;

import com.tientt.springmvc.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
    long countByUsernameAndPassword(String username, String password);
    Registration findByUsername(String username);
    List<Registration> getByLastnameContainingIgnoreCase(String lastname);
}
