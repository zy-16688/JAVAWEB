<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${ 3>4 }
    \${ 3>4 }
    <hr>
    <h3>算术运算符</h3>
    ${3+5}
    ${3-6}

    <h3>empty运算符</h3>
    <%
        String str= "abc";
        request.setAttribute("str",str);

        List list = new ArrayList();
        request.setAttribute("list",list);
    %>
<%--    ${empty 键名}  判断改键是否为空或者长度是否为0  是返回true--%>
    ${empty str}
    ${not empty list}
</body>
</html>
