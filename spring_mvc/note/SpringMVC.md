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

