<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
    <%
        User  user =new User();
        user.setName("张三");
        user.setAge(16);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

        List list = new ArrayList();
        list.add("add");
        list.add("haha");
        list.add(user);
        request.setAttribute("list",list);

        Map map =new HashMap();
        map.put("gender","男");
        map.put("name","战三");
        map.put("user",user);
        request.setAttribute("map",map);
    %>
    <h3>获取对象中的值</h3>
    ${requestScope.u.name}
    ${u.age}
<%--    调用了User类中的getBirthday方法--%>
    ${u.birthday}
<%--    调用了User类中的getBirStr方法
        获取对象中的值  ${域名.键名.属性}   属性指的是getter方法中 Name->name首字母小写转换
 --%>
    ${u.birStr}
    ${u.birthday.month}

    <h3>获取List中的值</h3>
    ${list}
<%--    获取list集合中的第一个值--%>
    ${list[0]}
<%--    获取list集合中的第三个值的值--%>
    ${list[2].name}

    <h3>获取Map集合中的值</h3>
    ${map.gender}
    ${map.user.name}
</body>
</html>
