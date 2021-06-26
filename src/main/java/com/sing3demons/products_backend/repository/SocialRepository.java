package com.sing3demons.products_backend.repository;

import com.sing3demons.products_backend.entity.Social;
import com.sing3demons.products_backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SocialRepository extends CrudRepository<Social, String> {
    Optional<Social> findByUser(User user);
}
