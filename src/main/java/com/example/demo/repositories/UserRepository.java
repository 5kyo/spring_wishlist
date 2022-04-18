package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUserName(String userName);


    Boolean existsByUserName(String userName);

    Boolean existsByUserEmail(String userEmail);

    @Query(value = "{call listAllUsers}", nativeQuery = true)
    List<User> listAllUsers();

    @Query(value = "{call listOneUser(:userId)}", nativeQuery = true)
    Optional<User> getSingleUser(@Param("userId") Long userId);
}
