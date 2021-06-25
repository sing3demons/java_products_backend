package com.sing3demons.products_backend.model;

import lombok.Data;

@Data
public class MRegisterRequest {
    private String email;

    private String password;

    private String name;
}
