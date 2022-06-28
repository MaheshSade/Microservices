package com.microservices.userservice.service;

import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUser(int id) {
        return repo.findById(id);
    }
}
