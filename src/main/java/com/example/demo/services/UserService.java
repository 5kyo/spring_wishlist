package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import com.example.demo.entities.User;
import com.example.demo.handler.ValidationException;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listAllUsers(){
        return userRepository.listAllUsers();
    }

    // public ArrayList<User> getAllUsers(){
    //     return (ArrayList<User>) userRepository.findAll();
    // }
    
    public Optional<User> getSingleUser(Long userId){
        if(userRepository.getSingleUser(userId).isEmpty()){
            throw new ValidationException("User not found or not exist");
        }
        
      return userRepository.getSingleUser(userId);
    }

    //public Optional<User> getSingleUser(Long userId){
    //    return userRepository.findById(userId);
    //}

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId){
        try{
            userRepository.deleteById(userId);
            return true;    
        }catch(Exception e){
            return false;
        }
    }
}
