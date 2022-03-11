<%--
  Created by IntelliJ IDEA.
  User: 24564
  Date: 2022/3/8
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <input type="text" name="userList[0].username"><br/>
        <input type="text" name="userList[0].age"><br/>

        <input type="text" name="userList[1].username"><br/>
        <input type="text" name="userList[1].age"><br/>

        <input type="submit" value="提交">


    </form>
</body>
</html>
