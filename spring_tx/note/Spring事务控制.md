## 编程式事务控制
### PlatformTransactionManager
- PlatformTransactionManager 接口是 spring 的事务管理器

| 方法 | 说明 |
| - | - |
| TransactionStatus getTransaction(TransactionDefinition definition) | 获取事务的状态信息 |
| void commit(TransactionStatus status) | 提交事务 |
| void rollback(TransactionStatus status) | 回滚事务 |

- TransactionDefinition（事务定义信息对象）

| 方法 | 说明 |
| - | - |
| int getIsolationLevel() | 获得事务的隔离级别 |
| int getPropagationBehavior() | 获得事务的传播行为 |
| int getTimeout() | 获得超时时间 |
| boolean isReadOnly() | 是否只读 |

- TransactionStatus（事务运行状态）

| 方法 | 说明 |
| - | - |
| boolean hasSavepoint() | 是否存储回滚点 |
| boolean isCompleted() | 事务是否完成 |
| boolean isNewTransaction() | 是否是新事务 |
| boolean isRollbackOnly() | 事务是否回滚 |

## 基于 XML 的声明式事务控制
### 实现
- 谁是切点？ => 业务方法
- 谁是通知？ => 事务控制
- 配置切面？

## 注解配置声明式事务控制解析
- 使用 `@Transaction` 在需要进行事务控制的类或是方法上修饰，注解可用的属性同 xml 配置方式，例如隔离级别、传播行为等
- 注解使用在类上，那么该类下的所有方法都使用同一套注解参数配置
- 使用在方法上，不同的方法可以采用不同的事务参数配置
- xml 配置文件中要开启事务的注解驱动 `<tx:annotation-driven />`