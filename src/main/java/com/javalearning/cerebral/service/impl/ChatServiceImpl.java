package com.javalearning.cerebral.service.impl;

import com.javalearning.cerebral.constant.PromptTemplates;
import com.javalearning.cerebral.dto.ChatRequest;
import com.javalearning.cerebral.dto.ChatResponse;
import com.javalearning.cerebral.service.ChatService;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {

    private final OpenAiChatModel chatModel;

    @Autowired
    public ChatServiceImpl(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * 格式化提示语
     * @param request
     * @return
     */
    private String formatPrompt(ChatRequest request) {
        String template = switch (request.getScene().toUpperCase()) {
            case "BUSINESS" -> PromptTemplates.BUSINESS_TEMPLATE;
            case "TECHNICAL_DOC" -> PromptTemplates.TECHNICAL_DOC_TEMPLATE;
            case "CODE_REVIEW" -> PromptTemplates.CODE_REVIEW_TEMPLATE;
            case "PRODUCT_FEATURE" -> PromptTemplates.PRODUCT_FEATURE_TEMPLATE;
            case "TROUBLESHOOTING" -> PromptTemplates.TROUBLESHOOTING_TEMPLATE;
            case "API_DOC" -> PromptTemplates.API_DOC_TEMPLATE;
            case "DATA_ANALYSIS" -> PromptTemplates.DATA_ANALYSIS_TEMPLATE;
            case "USER_FEEDBACK" -> PromptTemplates.USER_FEEDBACK_TEMPLATE;
            case "PERFORMANCE_OPTIMIZATION" -> PromptTemplates.PERFORMANCE_OPTIMIZATION_TEMPLATE;
            default -> PromptTemplates.GENERAL_TEMPLATE;
        };

        return String.format(template, request.getMessage());
    }

    /**
     * 生成回复
     * @param request
     * @return
     */
    @Override
    public ChatResponse generateResponse(ChatRequest request) {
        String promptText = formatPrompt(request);
        String response = chatModel.call(promptText);
        
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setContent(response);
        chatResponse.setScene(request.getScene());
        chatResponse.setTimestamp(System.currentTimeMillis());
        
        return chatResponse;
    }

    /**
     * 生成流式回复
     * @param request
     * @return
     */
    @Override
    public Flux<ChatResponse> generateStreamResponse(ChatRequest request) {
        String promptText = formatPrompt(request);
        return chatModel.stream(promptText)
                .map(response -> {
                    ChatResponse chatResponse = new ChatResponse();
                    chatResponse.setContent(response.toString());
                    chatResponse.setScene(request.getScene());
                    chatResponse.setTimestamp(System.currentTimeMillis());
                    return chatResponse;
                });
    }

}