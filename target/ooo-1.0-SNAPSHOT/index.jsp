<%--
  Created by IntelliJ IDEA.
  User: TEDU
  Date: 2021/12/1
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .all{
            display: inline-block;
        }
        .aa{
            margin-top: 95px;
            display: block;
            float: left;
        }
        .dd{
            margin-top: 70px;
            float: left;
            height: 40px;
            border: none;
        }
        .cc{
            width: 100%;
        }
        table{
            float: left;
        }
        .img{
            float: left;
        }
    </style>
    <script type="text/javascript">
        function changImg(){
            document.getElementById("bor").style['border'] = '2px solid red';
            document.getElementById("aa").innerText = "看不清,点击切换";
            var img = document.getElementById("servletImg");
            var d = new Date();
            var time = d.getTime();//如果没有这个
            //下面这一句不会起作用，因为浏览器的缓存技术，图片并不会刷新
            img.src="two?"+time;
            // alert(time)
            // location.href="/ooo/two?"+time;
            //?号后面的东西是通过get方式传递的


        }
    </script>
</head>
<body>

        <center>
            <div class="all">
                <form action="">
                    <table border="2">
                        <tr>
                            <td>用户名</td>
                            <td><input type="text"/></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="text" style="width: 100%;height: 100%" placeholder="请输入验证码"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button class="cc">登录</button></td>
                        </tr>
                    </table>
                        <div id="bor" class="dd">
                            <img class="img" id="servletImg"/>
                        </div>
                        <a class="aa" id="aa" href="javascript:changImg()">获取验证码</a>
                </form>
            </div>
        </center>

<br/>


</body>
</html>
