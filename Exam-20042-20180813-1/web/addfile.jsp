<%--
  Created by IntelliJ IDEA.
  User: xiaowei
  Date: 2018/8/13
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String path=request.getContextPath();
%>
<form action="${path}/film.do?p=addfilm" method="post">
    <a>id</a><input type="text" name="film_id" disabled="disabled" /><br><br>
    <a>title</a><input type="text" name="title"  /><br><br>
    <a>description</a><input type="text" name="description"  width="500px" /><br><br>
    <select name="lan">
        <c:forEach items="${list}" var="language">



            <option value="${language.language_id}" selected="selected" >${language.name}</option>

        </c:forEach>
    </select>
    <input id="login" type="submit" value="添加"/>
</form>


</body>
</html>