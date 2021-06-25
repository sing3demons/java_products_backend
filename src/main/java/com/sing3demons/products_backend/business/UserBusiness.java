package com.sing3demons.products_backend.business;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.model.MRegisterRequest;
import com.sing3demons.products_backend.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {
    private final IUserService userService;

    public UserBusiness(IUserService userService) {
        this.userService = userService;
    }


    public User register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        return user;
    }
}
