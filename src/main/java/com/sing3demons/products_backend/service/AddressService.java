package com.sing3demons.products_backend.service;

import com.sing3demons.products_backend.entity.Address;
import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.repository.AssressRepository;

import java.util.List;

public class AddressService implements IAddressService {
    private final AssressRepository repository;

    public AddressService(AssressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Address create(User user, String line1, String line2, String zipcode) {
        Address entity = new Address();
        entity.setUser(user);
        entity.setLine1(line1);
        entity.setLine2(line2);
        entity.setZipcode(zipcode);
        return repository.save(entity);
    }


}
