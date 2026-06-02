package com.spring.help.desk.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatClient(@RequestParam(value = "q") String message){

        String responseContent = this.chatClient.
                prompt(message).
                call().
                content();
        return ResponseEntity.ok(responseContent);
    }
}
