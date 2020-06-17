<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--    c:if标签
        1.属性:
            test 必须属性 接收boolean类型数据 若为true则显示if标签体中的内容 否则隐藏
       --%>
    <c:if test="true">
        <h1>我是if标签</h1>
    </c:if>
<br>
    <%
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);
        request.setAttribute("number",3);
    %>

    <c:if test="${not empty list}">
        list不为空执行循环
    </c:if><br>
    <c:if test="${number%2!=0}">
        ${number}是奇数
    </c:if>
    <c:if test="${number%2==0}">
        ${number}是偶数
    </c:if>
</body>
</html>
