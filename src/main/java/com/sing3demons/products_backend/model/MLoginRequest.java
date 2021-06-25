package com.sing3demons.products_backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MLoginRequest {
    private String email;

    private String password;
}
