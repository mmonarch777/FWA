<%--
  Created by IntelliJ IDEA.
  User: mmonarch
  Date: 1/18/23
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .block1 {
            width: 320px;
            background: #bbbc99;
            padding: 5px;
            border: solid 1px black;
            margin-top: 10px;
            margin-left: auto;
            margin-right: auto;
        }
        .block2 {
            width: 260px;
            padding: 5px;
            margin-left: auto;
            margin-right: auto;
        }
        .head {
            width: 320px;
            background: #bbbc99;
            padding: 5px;
            border: solid 1px black;
            text-align: center;
            margin: auto;
        }
        .button {
            width: 320px;
            background: #bbbc99;
            padding: 5px;
            border: solid 1px black;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
        .button2 {
            width: 260px;
            padding: 5px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class="head">Приветик</h1>

<form class="block1" method="post" action="/signIn">

    <div class="block2">
        <label><input type="text" name="name"></label>Имя<br>
    </div>
    <div class="block2">
        <label><input type="text" name="password"></label>Пароль<br>
    </div>
    <div class="button2" >
        <input type="submit" value="Войти">
    </div>
</form>

<form class="button" method="get" action="/signUp">
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
