## Spring 获取应用上下文工具
- 上次提交的是手动实现一个获取上下文工具，实际应用中不需要手写，Spring已经封装好了
- Spring 提供了一个监听器 `ContextLoaderListener` 就是对上述功能的封装， 
  该监听器内部加载Spring配置文件，创建应用上下文对象，并存储到 `ServletContext` 域中，
  提供了一个客户端工具 `WebApplicationContextUtils` 供使用者获得应用上下文对象
- 我们需要做的如下
  - 在 `web.xml` 中配置 `ContextLoaderListener` 监听器（导入 spring-web 坐标）
  - 使用 `WebApplicationContextUtils` 获得应用上下文对象 `ApplicationContext`