<%@ page import="java.util.List" %>
<%@ page import="com.example.dao.Student" %><%--
  Created by IntelliJ IDEA.
  User: TEDU
  Date: 2021/12/3
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查表</title>
    <style>
        table{
            border: 2px solid silver;
            border-collapse: collapse;
        }
        td{
            border: 1px solid lightsteelblue;
            padding: 20px;
        }
        .c{
            border:2px solid white;
            box-shadow: slategray 3px 3px 3px 3px;
            border-radius: 5px;
            text-decoration: none;
            padding: 5px 5px;
            font-weight: bold;
            font-size: 15px;
            /*a b c d:阴影x，y轴；阴影模糊宽度；阴影宽度*/
        }
        button:hover{
            cursor: hand;
        }
    </style>
</head>
<body>
<center>
<table>
    <tr>
        <td colspan="6" align="center">Students表</td>
    </tr>
<%
            List list =(List) application.getAttribute("key");
//            System.out.println("jsp---"+obj);
//            System.out.println("list:"+list.get(0));
            for(Object o : list){
                Student stu = (Student) o;
                String no = stu.getNo();
                String name = stu.getName();
                String sex = stu.getSex();
                String birthday = stu.getSbirthday();
                String clas = stu.getClas();

%>
    <tr>
        <td><%=no%></td>
        <td><%=name%></td>
        <td><%=sex%></td>
        <td><%=birthday%></td>
        <td><%=clas%></td>
        <td>
            <a id="a" class="c" href="/ooo/delete?no=<%=no%>" onmousedown="mousedown()" onmouseup="mouseup()"  style="background-color: darkturquoise;display: inline-block">删除</a>
            <a id="b" class="c" href=""  onmousedown="mousedown()" onmouseup="mouseup()"  style="background-color: hotpink;display: inline-block">修改</a>
        </td>
    </tr>
<%
            }
%>
        </table>
</center>
<script>
    /*鼠标按下事件*/
    function mousedown(event) {
        var e = window.event;
        var obj = e.srcElement;
        obj.style.color = 'white';
    }
    /*鼠标抬起事件*/
    function mouseup(event) {
        var e = window.event;
        var obj = e.srcElement;
        obj.style.color = 'black';
    }

</script>
</body>
</html>
