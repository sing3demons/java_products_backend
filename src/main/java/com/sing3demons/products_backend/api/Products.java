package com.sing3demons.products_backend.api;

import com.sing3demons.products_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();


        String userId = authentication.getPrincipal().toString();

        return ResponseEntity.ok(userRepository.findById(userId));
    }
}
