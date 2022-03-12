## 自定义 typeHandler
- 定义转换类继承类 `BaseTypeHandler<T>`
- 覆盖4个未实现的方法，其中 `setNonNullParameter` 为Java程序设置数据到数据库的回调方法(java->mysql)，
  `getNullableResult` 为查询时 MySQL 的字符串类型转换成 Java 的 Type 类型的方法(mysql->java)
- 在 MyBatis 核心配置文件中进行注册
- 测试转换是否正确

## plugins 标签
- 分页助手 `PageHelper`
    - 导入通用 PageHelper 坐标
    - 在 mybatis 核心配置文件中配置 PageHelper 插件
    - 测试分页数据获取