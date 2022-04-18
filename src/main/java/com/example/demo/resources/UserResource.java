package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserResource {
    
    @Autowired
    UserService userService;


    @GetMapping()
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    // @GetMapping()
    // public ArrayList<User> getAllUsers() {
    //     return userService.getAllUsers();
    // }

    @GetMapping( path = "/{id}" )
    public Optional<User> getSingleUser(@PathVariable("id") Long userId){
      return userService.getSingleUser(userId);
    }
    
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    @DeleteMapping( path = "/{id}" )
    public boolean deleteUser(@PathVariable("id") Long userId){
        return userService.deleteUser(userId);
    }

    
}
