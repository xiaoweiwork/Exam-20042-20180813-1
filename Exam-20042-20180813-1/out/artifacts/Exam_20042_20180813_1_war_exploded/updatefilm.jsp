<%--
  Created by IntelliJ IDEA.
  User: xiaowei
  Date: 2018/8/13
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>
<head>
    <title>Title</title>
    <script src="statics/jquery-3.3.1.min.js"></script>
    <script src="statics/myJs.js" type="text/javascript"></script>
</head>
<body>
<%
    String path=request.getContextPath();
%>
<form action="${path}/film.do?p=updatefilm" method="post">
    <a>id</a><input type="text" name="film_id" disabled="disabled" value="${film.film_id}" /><br><br>
    <a>title</a><input type="text" name="title"  value="${film.title}" /><br><br>
    <a>description</a><input type="text" name="description"  width="500px" value="${film.description}" /><br><br>
    <select name="lan">
        <c:forEach items="${list}" var="language">
            <option value="${language.language_id}" selected="selected" >${language.name}</option>
        </c:forEach>
    </select>
    <input id="update" type="submit" value="修改" />
</form>


</body>
</html>