package com.sing3demons.products_backend.model;

import lombok.Data;

@Data
public class UserRequest {
    private String email;

    private String password;

    private String name;
}
