<%--
  Created by IntelliJ IDEA.
  User: ruochen
  Date: 2022/3/7
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <script src="js/axios-0.18.0.js"></script>
        <script>
            var userList = [];
            userList.push({username: "zhangsan", age: 18});
            userList.push({username: "lisi", age: 28});
            console.log(JSON.stringify(userList));
            console.log(typeof JSON.stringify(userList))
            axios({
                method: "post",
                url: "${pageContext.request.contextPath}/user/quick15",
                data: JSON.stringify(userList),
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            }).then(resp => {

            })
        </script>
    </body>
</html>
