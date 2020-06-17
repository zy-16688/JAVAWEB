<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--    forEach
        重复操作
            属性:begin开始值 end结束值 var变量 step步长
         遍历容器
         for(user:list)
            属性 items类似于list  var类似于user
            varStatus:
                index容器中元素的索引
                count循环次数
--%>
    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${i} ${s.index} ${s.count}  <br>
    </c:forEach>
    <%
        List list =new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str} <br>
    </c:forEach>
</body>
</html>
