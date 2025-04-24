package com.javalearning.cerebral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
    private String content;  //  回复内容
    private String scene; // 场景
    private Long timestamp; //  时间戳
}
