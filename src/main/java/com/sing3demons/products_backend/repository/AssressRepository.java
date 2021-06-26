package com.sing3demons.products_backend.repository;

import com.sing3demons.products_backend.entity.Address;
import com.sing3demons.products_backend.entity.Social;
import com.sing3demons.products_backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssressRepository extends CrudRepository<Address, String> {
    List<Address> findByUser(User user);
}
