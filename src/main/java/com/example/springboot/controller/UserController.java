package com.example.springboot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }
}