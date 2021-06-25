package com.sing3demons.products_backend.api;

import com.sing3demons.products_backend.business.UserBusiness;
import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.mapper.UserMapper;
import com.sing3demons.products_backend.model.MLoginRequest;
import com.sing3demons.products_backend.model.MRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {


    private final UserBusiness business;
    private final UserMapper userMapper;

    public UserController(UserBusiness business, UserMapper userMapper) {
        this.business = business;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody MRegisterRequest request) throws BaseException {
        User response = business.register(request);
        return new ResponseEntity<>(userMapper.toRegisterResponse(response), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }
}
