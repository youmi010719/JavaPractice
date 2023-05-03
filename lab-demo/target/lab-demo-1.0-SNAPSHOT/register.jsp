<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/lab-demo/registerServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>
            <tr>
            <tr>
                <td>邮箱地址</td>
                <td class="inputs">
                    <input name="email" type="text" id="email">
                    <br>
                    <%--<span id="email_err" class="err_msg">${register_msg}</span>--%>
                </td>
            </tr>
            <tr>
                <td>工作</td>
                <td class="inputs">
                    <input name="userwork" type="text" id="userwork">
                    <br>
                    <%--<span id="userwork_err" class="err_msg">${register_msg}</span>--%>
                </td>
            </tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/lab-demo/checkCodeServlet">
                    <a href="#" id="changeImg" >看不清？</a>
                </td>
            </tr>

            <script>
                document.getElementById("changeImg").onclick = function () {
                    //路径后面添加时间戳的目的是避免浏览器进行缓存静态资源
                    document.getElementById("checkCodeImg").src = "/lab-demo/checkCodeServlet?"+new Date().getMilliseconds();
                }
            </script>
        </table>
        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
</body>
</html>