package com.spring.help.desk.service;

import com.spring.help.desk.tools.EmailTool;
import com.spring.help.desk.tools.TicketDatabaseTool;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.core.io.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class AiService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    private final EmailTool emailTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPrompt;

    public String getResponseFromAssistant(String query, String conversationId){
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(ticketDatabaseTool, emailTool)
                .system(systemPrompt)
                .user(query)
                .call()
                .content();
    }
}
