package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserResource {
    
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping( path = "/{userId}" )
    public Optional<User> getSingleUser(@PathParam("userId") Long userId) {
        return userService.getSingleUser(userId);
    }
    
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    
}
