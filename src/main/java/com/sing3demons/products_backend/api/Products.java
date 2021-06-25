package com.sing3demons.products_backend.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class Products {
    @GetMapping("/")
    public ResponseEntity<Map> findAll() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        return ResponseEntity.ok(map);
    }
}
