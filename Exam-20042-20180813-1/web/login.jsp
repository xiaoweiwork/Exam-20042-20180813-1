<%--
  Created by IntelliJ IDEA.
  User: xiaowei
  Date: 2018/8/13
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script src="statics/jquery-3.3.1.min.js"></script>
    <script src="statics/myJs.js" type="text/javascript"></script>
</head>
<body>
<%
    String path=request.getContextPath();
    //out.print(path);
%>

    <div class="login">
        <form action="${path}/user.do?p=login" method="post">
            <a>用户名</a><input type="text" name="username" id="name" />
            <input id="login" type="submit" value="登录" />
        </form>


    </div>
</body>
</html>
