<%--
  Created by IntelliJ IDEA.
  User: ruochen
  Date: 2022/3/12
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>添加账户信息表单</h1>
        <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
            账户名称：<input type="text" name="name"><br/>
            账户金额：<input type="text" name="money"><br/>
            <input type="submit" value="保存"><br/>
        </form>
    </body>
</html>
