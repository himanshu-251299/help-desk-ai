package com.spring.help.desk.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class AiService {

    private final ChatClient chatClient;

    public String getResponseFromAssistant(String query){
        return this.chatClient
                .prompt()
                .user(query)
                .call()
                .content();
    }
}
