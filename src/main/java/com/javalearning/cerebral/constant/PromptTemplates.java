package com.javalearning.cerebral.constant;

public class PromptTemplates {
    // 通用模板
    public static final String GENERAL_TEMPLATE = """
            请根据以下要求生成回复：
            用户输入：%s
            要求：
            1. 保持专业性和友好性
            2. 回答要简洁明了
            3. 如果涉及专业术语，请做简要解释
            """;

    // 商业模板
    public static final String BUSINESS_TEMPLATE = """
            你是一个专业的商业顾问，请根据以下业务场景提供建议：
            场景描述：%s
            要求：
            1. 提供具体可行的建议
            2. 考虑实际可操作性
            3. 使用专业但易懂的语言
            """;
    // 技术文档生成模板
    public static final String TECHNICAL_DOC_TEMPLATE = """
            请为以下技术内容生成标准文档：
            内容：%s
            要求：
            1. 使用markdown格式
            2. 包含代码示例（如适用）
            3. 清晰的章节结构
            4. 包含使用注意事项
            5. 添加常见问题解答部分
            """;

    // 代码优化建议模板
    public static final String CODE_REVIEW_TEMPLATE = """
            请对以下代码进行审查和优化建议：
            代码：%s
            审查重点：
            1. 代码质量和最佳实践
            2. 性能优化机会
            3. 安全性考虑
            4. 可维护性改进
            5. 具体的修改建议
            """;

    // 产品功能描述模板
    public static final String PRODUCT_FEATURE_TEMPLATE = """
            请为以下产品功能生成详细描述：
            功能概述：%s
            输出要求：
            1. 功能详细说明
            2. 用户价值点
            3. 使用场景示例
            4. 技术实现要点
            5. 注意事项和限制
            """;

    // 问题诊断模板
    public static final String TROUBLESHOOTING_TEMPLATE = """
            请帮助诊断并解决以下问题：
            问题描述：%s
            分析步骤：
            1. 问题症状分析
            2. 可能的原因
            3. 排查步骤
            4. 解决方案建议
            5. 预防措施
            """;

    // API文档生成模板
    public static final String API_DOC_TEMPLATE = """
            请为以下API生成标准文档：
            API描述：%s
            文档结构：
            1. 接口概述
            2. 请求/响应格式
            3. 参数说明
            4. 错误码说明
            5. 调用示例
            6. 注意事项
            """;

    // 数据分析报告模板
    public static final String DATA_ANALYSIS_TEMPLATE = """
            请对以下数据进行分析并生成报告：
            数据内容：%s
            报告要求：
            1. 数据概述
            2. 关键指标分析
            3. 趋势识别
            4. 异常说明
            5. 建议措施
            """;

    // 用户反馈响应模板
    public static final String USER_FEEDBACK_TEMPLATE = """
            请针对以下用户反馈生成专业回复：
            用户反馈：%s
            回复要求：
            1. 感谢用户反馈
            2. 理解并复述问题
            3. 提供解决方案
            4. 后续跟进计划
            5. 温和专业的语气
            """;

    // 性能优化建议模板
    public static final String PERFORMANCE_OPTIMIZATION_TEMPLATE = """
            请为以下系统/代码提供性能优化建议：
            优化对象：%s
            分析维度：
            1. 当前性能瓶颈
            2. 可优化点分析
            3. 具体优化方案
            4. 预期改进效果
            5. 实施风险评估
            """;
}