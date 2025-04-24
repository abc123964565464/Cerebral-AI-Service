package com.javalearning.cerebral.service;

import com.javalearning.cerebral.dto.ChatRequest;
import com.javalearning.cerebral.dto.ChatResponse;
import reactor.core.publisher.Flux;

public interface ChatService {
    /**
     * 生成回复
     * @param request
     * @return
     */
    ChatResponse generateResponse(ChatRequest request);

    /**
     * 生成流式回复
     * @param request
     * @return
     */
    Flux<ChatResponse> generateStreamResponse(ChatRequest request);
}