package com.sing3demons.products_backend.exception;

public class ChatExeption extends BaseException {
    public ChatExeption(String message) {
        super("chat." + message);
    }

    public static ChatExeption accessDenied() {
        return new ChatExeption("access.denies");
    }
}
