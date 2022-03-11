## 异常处理两种方式
- 使用 SpringMVC 提供的简单异常处理器 `SimpleMappingExceptionResolver`
- 使用Spring 的异常处理器接口 `HandlerExceptionResolver` 自定义自己的异常处理器

## 自定义异常处理器
- 创建异常处理器类实现 `HandlerExceptionResolver`
- 配置异常处理器
- 编写异常页面
- 测试异常跳转