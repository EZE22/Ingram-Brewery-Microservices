package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String welcomeUserMessage() {
        return "Welcome to the User Service....";
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public User getBeerByName(@PathVariable("name") String name) {
        return userRepository.findAllByUsername(name);
    }

}
