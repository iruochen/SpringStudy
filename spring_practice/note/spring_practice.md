## 角色列表展示
### 步骤分析
- 点击角色管理菜单发送请求到服务端（修改角色管理菜单的url地址）
- 创建 RoleController 的 showList() 方法
- 创建 RoleService 的 showList() 方法
- 创建 RoleDao 的 findALl() 方法
- 使用 JdbcTemplate 完成查询操作
- 将查询数据存储到 Model 中
- 转发到 `role-list.jsp` 页面进行展示


## 角色添加
### 步骤分析
- 点击列表页面新建按钮跳转到角色添加页面
- 输入角色信息，点击保存按钮，表单数据提交服务器
- 编写 RoleController 的 save() 方法
- 编写 RoleService 的 save() 方法
- 编写 RoleDao 的 save() 方法
- 使用 JdbcTemplate 保存 Role 数据到 sys_role
- 跳转回角色列表页面