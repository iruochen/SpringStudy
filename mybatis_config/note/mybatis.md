## 自定义 typeHandler
- 定义转换类继承类 `BaseTypeHandler<T>`
- 覆盖4个未实现的方法，其中 `setNonNullParameter` 为Java程序设置数据到数据库的回调方法(java->mysql)，
`getNullableResult` 为查询时 MySQL 的字符串类型转换成 Java 的 Type 类型的方法(mysql->java)
- 在 MyBatis 核心配置文件中进行注册
- 测试转换是否正确