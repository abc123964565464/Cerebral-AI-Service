package com.javalearning.cerebral.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cerebralOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cerebral AI Service API")
                        .description("智能文本生成服务接口文档")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("your name")
                                .email("your email")));
    }
}