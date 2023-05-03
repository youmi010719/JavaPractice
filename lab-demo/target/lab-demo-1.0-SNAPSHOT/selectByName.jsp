<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>查询品牌</title>
</head>
<body>
<h3>查询品牌</h3>
<form action="/lab-demo/selectBrandByNameServlet" method="post">
    品牌名称：<input name="brandName"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>