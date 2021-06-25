package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.exception.UserException;
import com.sing3demons.products_backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncode;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncode) {
        this.userRepository = userRepository;

        this.passwordEncode = passwordEncode;
    }


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncode.matches(rawPassword,encodedPassword);
    }

    @Override
    public User create(String email, String password, String name) throws BaseException {

        // validate
        if (Objects.isNull(email)) {
            throw UserException.createEmail();
        }

        if (Objects.isNull(password)) {
            throw UserException.createPasswordNull();
        }

        if (Objects.isNull(name)) {
            throw UserException.createNameNull();
        }

        // verify
        if (userRepository.existsByEmail(email)) {
            throw UserException.createEmailDuplicated();
        }
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(passwordEncode.encode(password));
        entity.setName(name);

        return userRepository.save(entity);
    }
}
