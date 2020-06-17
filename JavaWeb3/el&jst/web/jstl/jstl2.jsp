<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%--    choose标签  test属性写条件
         choose 相当于switch
         when  相当于case
         otherwise 相当于 default
--%>
    <%
        request.setAttribute("number",3);
    %>
    <c:choose>
        <c:when test="${number==1}">星期一</c:when>
        <c:when test="${number==2}">星期二</c:when>
        <c:when test="${number==3}">星期三</c:when>
        <c:when test="${number==4}">星期四</c:when>
        <c:when test="${number==5}">星期五</c:when>
        <c:when test="${number==6}">星期六</c:when>
        <c:when test="${number==7}">星期天</c:when>
        <c:otherwise>数字有误</c:otherwise>
    </c:choose>
</body>
</html>
