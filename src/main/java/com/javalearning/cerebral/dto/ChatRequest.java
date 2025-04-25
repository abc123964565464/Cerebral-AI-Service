package com.javalearning.cerebral.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "智能文本生成请求参数")
public class ChatRequest {
    @NotBlank(message = "信息不能为空")
    @Schema(description = "用户输入信息")
    private String message;

    @Schema(description = "业务场景标识")
    private String scene; // 业务场景标识
}
