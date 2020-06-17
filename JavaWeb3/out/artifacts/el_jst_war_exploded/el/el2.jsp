<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <%
        request.setAttribute("msg","jaja");
        session.setAttribute("age",16);
    %>
    ${域名.键名}
    ${requestScope.msg
    }
    ${sessionScope.age}
</body>
</html>
