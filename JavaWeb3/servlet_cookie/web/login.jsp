<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.addEventListener("load",function(){
            var img = document.querySelector("#img");
            img.addEventListener("click",function(){
                var date = +new Date();
                this.src="/day16/checkcodeDemo?time"+date;
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="/day16/checkcodeDemo" alt="" id="img"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>

        </tr>
    </table>
<%--    获取相应的登陆信息--%>
    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>
</form>
</body>
</html>
