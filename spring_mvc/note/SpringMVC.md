## SpringMVC 开发步骤
- 导入 SpringMVC 相关坐标
- 配置 SpringMVC 核心控制器 DispatcherServlet
- 创建 Controller 类和视图页面
- 使用注解配置 Controller 类中业务方法的映射地址
- 配置 SpringMVC 核心文件 spring-mvc.xml
- 客户端发起请求测试

## SpringMVC 执行流程
- 用户发送请求至前端控制器 DispatcherServlet
- DispatcherServlet 收到请求调用 HandlerMapping 处理器映射器
- 处理器映射器找到具体的处理器（可以根据 xml 配置、注解进行查找），生成处理器对象及处理器
拦截器（如果有则生成），并返回给 DispatcherServlet
- DispatcherServlet 调用 HandlerAdaptor 处理器适配器
- HandlerAdaptor 经过适配调用具体的处理器（Controller，也叫后端控制器）
- Controller 执行完成返回 ModelAndView
- HandlerAdaptor 将 controller 执行结果 ModelAndView 返回给 DispatcherServlet
- DispatcherServlet 将 ModelAndView 传给 ViewResolver 视图解析器
- ViewResolver 解析后返回具体 View
- DispatcherServlet 根据 View 进行渲染视图（即将模型数据填充至视图中）。DispatcherServlet 响应用户

## SpringMVC 数据响应方式
### 页面跳转
- 直接返回字符串：此种方式会将返回的字符串与视图解析器的前后缀拼接后跳转
- 通过 ModelAndView 对象返回
### 回写数据
- 直接返回字符串
  - 传统：`response.getWriter().print("hello world")`
  - Spring 框架
    - 注入 response 对象，通过 `response.getWriter().print("hello world")` 回写数据，此时不需要视图跳转，业务返回值为 void
    - 将需要回写的字符串直接返回，添加 `@ResponseBody` 注解
- 返回对象或集合
  - 方式一：`spring-mvc.xml` 中进行配置
  - 方式二：使用 MVC 的注解驱动代替方式一配置 `<mvc:annotation-driven/>`
    - 在 SpringMVC 的各个组件中，**处理器映射器**、**处理器适配器**、**视图解析器** 称为 SpringMVC 的三大组件
    - 使用 `<mvc:annotaion-driven>` 自动加载 `RequestMappingHandlerMapping`(处理器映射器) 和 `RequestMappingHandlerAdapter`(处理器适配器)
    - 可以在 `spring-mvc.xml` 文件中使用 `<mvc:annotation-driven>` 替代注解处理器和配置器的配置
    - 同时使用 `<mvc:annotation-driven>` 默认底层就会集成 jackson 进行对象或集合的 json 格式字符串的转换


