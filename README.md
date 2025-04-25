# Cerebral - AI Text Generation Service

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)

## 🌟 项目简介

Cerebral-AI-Service 是一个基于 Spring Boot 和 DeepSeek AI 模型的智能文本生成服务。它提供了一个简洁而强大的 API 接口，支持多场景文本生成，包括技术文档、代码审查、API 文档等多种业务场景。

### ✨ 特性亮点

- 🚀 支持实时流式响应
- 🎯 多场景模板支持
- 🛡️ 统一的响应格式
- 📝 完善的参数验证
- 🔄 优雅的异常处理
- 📊 请求限流保护

## 🔧 技术栈

- Java 17
- Spring Boot 3.x
- DeepSeek AI API
- Project Lombok
- Spring Validation
- Reactive Streams
- springdoc-openapi

## 🚀 快速开始

### 前置要求

- JDK 17+
- Maven 3.6+
- DeepSeek API Key

### 配置文件

```yaml
spring:
  application:
    name: Cerebral
  datasource:
    url: jdbc:mysql://localhost:3306/deepseek_db?useSSL=false&serverTimezone=UTC
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  ai:
    openai:
      base-url: https://api.deepseek.com
      api-key: your_api_key
      chat:
        options:
          model: 'deepseek-reasoner'
```

### 构建运行

```bash
# 克隆项目
git clone https://github.com/abc123964565464/cerebral.git

# 进入项目目录
cd cerebral

# 安装依赖
mvn clean install

# 运行项目
mvn spring-boot:run
```

## 📚 API 文档

### 生成文本

```http
POST /api/v1/chat/generate
Content-Type: application/json

{
    "message": "介绍Spring Boot的优势",
    "scene": "TECHNICAL_DOC"
}
```

### 流式生成

```http
POST /api/v1/chat/generate-stream
Content-Type: application/json

{
    "message": "介绍Spring Boot的优势",
    "scene": "TECHNICAL_DOC"
}
```

### 支持的场景类型

- `GENERAL` - 通用对话
- `BUSINESS` - 商业建议
- `TECHNICAL_DOC` - 技术文档
- `CODE_REVIEW` - 代码审查
- `API_DOC` - API文档
- `TROUBLESHOOTING` - 问题诊断
- ... [查看更多](#场景类型)

## 🎯 项目结构

```
src/main/java/com/javalearning/cerebral/
├── config/          # 配置文件
├── constant/        # 常量模板
├── controller/      # 控制器
├── dto/      
│   ├── ChatRequest/ # 请求封装
│   ├── response/    # 响应封装
├── exception/       # 异常处理
├── service/         # 业务逻辑

```

## 🔮 后续计划

- [ ] 美化输出样式
- [ ] 添加用户认证
- [ ] 实现对话上下文管理
- [ ] 添加更多 AI 模型支持
- [ ] 优化响应速度
- [ ] 添加更多场景模板

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request！

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交改动 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

## 📄 开源协议

本项目使用 [MIT](LICENSE) 协议开源。

## 🙏 鸣谢

- [Spring Boot](https://spring.io/projects/spring-boot)
- [DeepSeek AI](https://deepseek.com)
```