package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);

    User create(String email, String password, String name) throws BaseException;
}
