package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.Address;
import com.sing3demons.products_backend.entity.User;

import java.util.List;

public interface IAddressService {
    List<Address> findByUser(User user);
    Address create(User user, String line1, String line2, String zipcode);
}
