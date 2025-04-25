package com.javalearning.cerebral.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "智能文本生成回复")
public class ChatResponse {

    @Schema(description = "回复内容")
    private String content;  //  回复内容
    @Schema(description = "业务场景标识")
    private String scene; // 场景
    @Schema(description = "时间戳")
    private Long timestamp; //  时间戳
}
