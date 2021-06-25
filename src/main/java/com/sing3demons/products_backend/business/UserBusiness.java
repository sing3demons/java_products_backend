package com.sing3demons.products_backend.business;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.exception.UserException;
import com.sing3demons.products_backend.model.MLoginRequest;
import com.sing3demons.products_backend.model.MRegisterRequest;
import com.sing3demons.products_backend.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String login(MLoginRequest request) throws BaseException {
        // validate request

        // verify database
        Optional<User> opt = userService.findByEmail(request.getEmail());
        if (opt.isEmpty()) {
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if (!userService.matchPassword(request.getPassword(), user.getPassword())) {
            throw UserException.loginFailPasswordIncorrect();
        }

        // TODO: generate JWT
        String token = "JWT TO DO";

        return token;
    }
}
