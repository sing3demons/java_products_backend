package com.sing3demons.products_backend.controller;

import com.sing3demons.products_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class Products {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {

        return ResponseEntity.ok("Hello, World");
    }
}
