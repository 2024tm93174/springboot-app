package com.example.springboot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}