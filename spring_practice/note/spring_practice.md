## 角色列表展示
### 步骤分析
- 点击角色管理菜单发送请求到服务端（修改角色管理菜单的url地址）
- 创建 RoleController 和 showList() 方法
- 创建 RoleService 和 showList() 方法
- 创建 RoleDao 和 findALl() 方法
- 使用 JdbcTemplate 完成查询操作
- 将查询数据存储到 Model 中
- 转发到 `role-list.jsp` 页面进行展示