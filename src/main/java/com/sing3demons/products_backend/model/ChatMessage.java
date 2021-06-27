package com.sing3demons.products_backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ChatMessage {
    private String from;
    private String message;
    private Date created;
    public ChatMessage(){
        created = new Date();
    }
}
