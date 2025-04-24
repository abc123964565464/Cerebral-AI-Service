package com.javalearning.cerebral.controller;

import com.javalearning.cerebral.dto.ChatRequest;
import com.javalearning.cerebral.dto.ChatResponse;
import com.javalearning.cerebral.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * 生成回复
     * @param request
     * @return
     */
    @PostMapping("/generate")
    public ChatResponse generate(@RequestBody ChatRequest request) {
        return chatService.generateResponse(request);
    }

    // 添加 GET 方法，用于简单请求
    @GetMapping("/generate")
    public ResponseEntity<ChatResponse> generateGet(
            @RequestParam(required = false, defaultValue = "Hello") String message,
            @RequestParam(required = false, defaultValue = "GENERAL") String scene) {
        ChatRequest request = new ChatRequest();
        request.setMessage(message);
        request.setScene(scene);
        return ResponseEntity.ok(chatService.generateResponse(request));
    }

    /**
     * 生成流式回复
     * @param request
     * @return
     */
    @PostMapping("/generate-stream")
    public Flux<ChatResponse> generateStream(@RequestBody ChatRequest request) {
        return chatService.generateStreamResponse(request);
    }
}