<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>${user.username},欢迎您</h1>
<input type="button" value="退出" id="login">
<hr>
<%--<input type="button" value="新增" id="add"><br>--%>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>用户邮箱</th>
<%--
        <th>用户工作</th>
--%>
        <th>操作</th>
    </tr>

    <%-- 这里的Id这一个属性是自增长的，特殊处理的--%>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr align="center">
                <%--<td>${user.id}</td>--%>
            <td>${status.count}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
<%--
            <td>${user.userwork}</td>
--%>

            <td><a href="/lab-demo/selectByIdServlet?id=${user.id}">修改</a> <a href="/lab-demo/deleteByIdServlet?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<%--对于用户表，只实现查询所有，暂时不做修改，添加操作--%>
<script>
    document.getElementById("add").onclick = function (){
        location.href = "/lab-demo/adduser.jsp";
    }
</script>
<script>
    document.getElementById("login").onclick = function (){
        location.href = "/lab-demo/login.jsp";
    }
</script>
</body>
</html>