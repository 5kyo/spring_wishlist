package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.demo.entities.ERole;
import com.example.demo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Optional<Role> findByRoleName(ERole roleName);
}
