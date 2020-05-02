package com.pki.PKI.controller;

import com.pki.PKI.domain.User;
import com.pki.PKI.repository.TestRepository;
import com.pki.PKI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestRepository testRepository;

    @GetMapping("/users")
    public String getAllUsers() {
        //return userRepository.findAll();
        return userRepository.findAll().toString();
    }

    @GetMapping("/test")
    public String getAllTests() {
        return testRepository.findAll().toString();
    }

}
