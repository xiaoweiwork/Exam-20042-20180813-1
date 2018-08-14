<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaowei
  Date: 2018/8/13
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
  <title>功能展示</title>

  <style>
    table{
      border: 1px red solid;
      border-collapse: collapse;
    }
    td{
      width: 200px;
      height: 30px;
    }
   a{
     text-decoration: none;
   }
    a:hover{
      color: brown;
    }
  </style>
</head>
<body>
<%
  String path=request.getContextPath();
%>
<table>
  <tr>
    <td><a href="login.jsp">用户登录</a></td>
    <td><a href="film.do?p=fengye&size=5&page=1">展示电影</a></td>
    <td><a href="film.do?p=delete&film_id=${film.film_id}&size=${map.size}&page=${map.page}">删除电影</a></td>
    <td><a href="#">修改电影</a></td>
    <td><a href="film.do?p=add">添加电影</a></td>
  </tr>
</table>
</body>
</html>
