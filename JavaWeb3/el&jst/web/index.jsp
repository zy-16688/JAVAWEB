<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<%@ include file="500.jsp" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 指令  <%@ 指令名称 属性名1=属性值1 >
     page: contentype  相当于request中的setContentType
            erroPage  当前页面发生异常后会自动跳转到指定的错误页面
            isErrorpage   标志当前是错误页面  可以使用内置对象exception输出错误信息
            include  页面包含导入页面的资源文件  <%@ include file="文件路径" %>
            taglib 导入资源      <%@ taglib prefix="前缀" uri="包名" >
     --%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      ArrayList list = new ArrayList();
        int i=5;
        i=i/0;
    %>
    <%  pageContext.setAttribute("msg","hahah") ; %>
    <%=pageContext.getAttribute("msg")%>
  </body>

</html>
