package com.sing3demons.products_backend.controller;

import com.sing3demons.products_backend.business.UserBusiness;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.mapper.UserMapper;
import com.sing3demons.products_backend.model.MLoginRequest;
import com.sing3demons.products_backend.model.MRegisterRequest;
import com.sing3demons.products_backend.model.MRegisterResponse;
import com.sing3demons.products_backend.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {


    private final UserBusiness business;
    private final UserMapper userMapper;

    public UserController(UserBusiness business, UserMapper userMapper) {
        this.business = business;
        this.userMapper = userMapper;
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> getProfile() throws BaseException {
        UserResponse response = business.getProfile();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody MRegisterRequest request) throws BaseException {
        MRegisterResponse response = business.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String> refreshToken() throws BaseException {
        String response = business.refreshToken();
        return ResponseEntity.ok(response);
    }
}
