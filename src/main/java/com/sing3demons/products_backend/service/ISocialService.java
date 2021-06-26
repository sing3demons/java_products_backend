package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.Social;
import com.sing3demons.products_backend.entity.User;

import java.util.Optional;

public interface ISocialService {
    Optional<Social> findByUser(User user);
    Social create(User user, String facebook, String line, String instagram, String tiktok);
}
