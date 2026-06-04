package com.spring.help.desk.controller;

import com.spring.help.desk.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(aiService.getResponseFromAssistant(query, conversationId));
    }

    @PostMapping("/stream")
    public Flux<String> streamResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId){
        return this.aiService.streamResponseFromAssistant(query, conversationId);
    }

}
