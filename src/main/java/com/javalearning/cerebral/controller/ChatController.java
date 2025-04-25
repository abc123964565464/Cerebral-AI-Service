package com.javalearning.cerebral.controller;

import com.javalearning.cerebral.dto.ChatRequest;
import com.javalearning.cerebral.dto.ChatResponse;
import com.javalearning.cerebral.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "Chat API", description = "提供智能文本生成服务的相关 API")
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
    @Operation(summary = "生成文本回复", description = "根据用户输入和业务场景生成文本回复")
    public ChatResponse generate(@RequestBody ChatRequest request) {
        return chatService.generateResponse(request);
    }

    // 添加 GET 方法，用于简单请求
    @Operation(summary = "生成简单回复", description = "根据请求参数生成简单回复")
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
    @Operation(summary = "生成流式回复", description = "根据请求参数生成流式回复")
    public Flux<ChatResponse> generateStream(@RequestBody ChatRequest request) {
        return chatService.generateStreamResponse(request);
    }
}