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
    <script src="statics/jquery-3.3.1.min.js"></script>
    <script src="statics/myJs.js" type="text/javascript"></script>
    <style>
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
    //out.print(path);
%>
<table>
    <thead>
        <td>电影ID</td>
        <td>电影名</td>
        <td>电影描述</td>
        <td>语言</td>
        <td>操作</td>
    </thead>
    <%--private  String title;--%>
    <%--private String description;--%>
    <%--private String language;--%>
    <%--private  int language_id;--%>

    <c:forEach items="${map.list}" var="film">
        <tr>
            <td>${film.film_id}</td>
            <td>${film.title}</td>
            <td>${film.description}</td>
            <td>${film.language}</td>
            <td>
                <button  ><a href="${path}/film.do?p=delete&film_id=${film.film_id}&size=${map.size}&page=${map.page}">删除</a></button>
                <button  ><a href="${path}/film.do?p=update&film_id=${film.film_id}&size=${map.size}&page=${map.page}">修改</a></button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5"><a href="/film.do?p=add">添加电影</a></td>
    </tr>
    共${map.countpage}页/第${map.page}页
    <a href="film.do?p=fengye&size=5&page=1">【首页】</a>
    <a href="film.do?p=fengye&size=${map.size}&page=${map.page-1}">【上一页】</a>
    <a href="film.do?p=fengye&size=${map.size}&page=${map.page+1}">【下一页】</a>
    <a href="film.do?p=fengye&size=${map.size}&page=${map.countpage}">【尾页】</a>
</table>
<a id="aaa">${n}</a>
<script>
    var value = "${requestScope.n}";
    if(value>0){
        alert("成功");
    }
</script>
</body>
</html>
