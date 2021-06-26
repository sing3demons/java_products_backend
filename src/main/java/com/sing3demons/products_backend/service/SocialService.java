package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.Social;
import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.repository.SocialRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocialService implements ISocialService {
    private final SocialRepository repository;

    public SocialService(SocialRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Social> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Social create(User user, String facebook, String line, String instagram, String tiktok) {
        // TODO: validate

        // create
        Social entity = new Social();
        entity.setUser(user);
        entity.setFacebook(facebook);
        entity.setLine(line);
        entity.setInstagram(instagram);
        entity.setTiktok(tiktok);

        return repository.save(entity);
    }
}
