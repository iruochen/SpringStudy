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

