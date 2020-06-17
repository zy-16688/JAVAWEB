<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--        获取session中对应的值--%>
    <h1><%=request.getSession().getAttribute("user")%>欢迎你</h1>
</body>
</html>
