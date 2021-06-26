package com.sing3demons.products_backend.business;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.exception.UserException;
import com.sing3demons.products_backend.mapper.UserMapper;
import com.sing3demons.products_backend.model.MLoginRequest;
import com.sing3demons.products_backend.model.MRegisterRequest;
import com.sing3demons.products_backend.model.MRegisterResponse;
import com.sing3demons.products_backend.model.UserResponse;
import com.sing3demons.products_backend.service.IUserService;
import com.sing3demons.products_backend.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusiness {
    private final IUserService userService;
    private final TokenService tokenService;
    private final UserMapper userMapper;

    public UserBusiness(IUserService userService, TokenService tokenService, UserMapper userMapper) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.userMapper = userMapper;
    }

    public UserResponse getProfile() throws BaseException{
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();


        String userId = authentication.getPrincipal().toString();
        Optional<User> opt = userService.getProfile(userId);
        if (opt.isEmpty()) {
            throw UserException.notFound();
        }

        User user = opt.get();
        return userMapper.toUserResponse(user);
    }

    public MRegisterResponse register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        return userMapper.toRegisterResponse(user);
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


        String token = tokenService.tokenize(user);

        return token;
    }

    public String refreshToken() throws BaseException {
//        Optional<String> opt = SecurityUtil.getCurrentUserId();
//
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();


        String userId = authentication.getPrincipal().toString();
        Optional<User> opt = userService.findById(userId);
        if (opt.isEmpty()) {
            throw UserException.notFound();
        }

        User user = opt.get();
        return tokenService.tokenize(user);
    }
}
