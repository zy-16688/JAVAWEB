<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%--    完成从list集合中取出数据并将数据输出在表格内--%>
    <%
        List list = new ArrayList();
        list.add(new User("张三",23,new Date()));
        list.add(new User("李四",24,new Date()));
        list.add(new User("王五",25,new Date()));
        request.setAttribute("list",list);
    %>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
<%--        foreach循环 items记得用${list}--%>
        <c:forEach items="${list}" var="user" varStatus="s">
            <c:if test="${s.count%2==0}">
<%--         若是偶数行 则背景色修改为红色
            ${s.count} 代表的是遍历的次数
            ${user.name} 代表的是list集合中user对象中的名字
--%>
                <tr bgcolor="red">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
<%--            数据行--%>
            <c:if test="${s.count%2!=0}">
                <tr bgcolor="green">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>

        </c:forEach>
    </table>
</body>
</html>
