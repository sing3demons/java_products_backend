package com.sing3demons.products_backend.business;

import com.sing3demons.products_backend.exception.BaseException;
import com.sing3demons.products_backend.exception.ChatExeption;
import com.sing3demons.products_backend.model.ChatMessage;
import com.sing3demons.products_backend.model.ChatMessageRequest;
import com.sing3demons.products_backend.util.SecurityUtil;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatBusiness {
    private final SimpMessagingTemplate template;

    public ChatBusiness(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void post(ChatMessageRequest request) throws BaseException {
        Optional<String> optional = SecurityUtil.getCurrentUserId();
        if (optional.isEmpty()) {
            throw ChatExeption.accessDenied();
        }

        final String destination = "/topic/chat";
        ChatMessage payload = new ChatMessage();
        payload.setFrom(optional.get());
        payload.setMessage(request.getMessage());

        template.convertAndSend(destination, payload);
    }
}
