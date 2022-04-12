package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    @Query(value = "{call list_procedure()}", nativeQuery = true)
    List<User> listProcedure();
}
