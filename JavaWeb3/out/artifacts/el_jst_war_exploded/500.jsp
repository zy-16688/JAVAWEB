<%@ page import="com.sun.corba.se.spi.protocol.RequestDispatcherRegistry" %>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙</h1>
    <%
        //可以获取错误的信息    isErroPage为true的话则可以使用exception打印错误消息
        String msg = exception.getMessage();
        out.print(msg);
    %>
</body>
</html>
