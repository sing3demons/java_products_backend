package com.sing3demons.products_backend.api;

import com.sing3demons.products_backend.business.UserBusiness;
import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
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


    private UserBusiness business;

    public UserController(UserBusiness business) {
        this.business = business;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody MRegisterRequest request) throws BaseException {
        User response = business.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
