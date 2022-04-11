package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getAllUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> getSingleUser(Long userId){
        return userRepository.findById(userId);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
