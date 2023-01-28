<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmonarch
  Date: 1/18/23
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
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
            width: 280px;
            padding: 5px;
            margin-left: auto;
            margin-right: auto;
        }
        .button {
            width: 260px;
            padding: 5px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
        .head {
            width: 320px;
            background: #bbbc99;
            padding: 5px;
            border: solid 1px black;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h1 class="head">Регистрация</h1>
<form class="block1" method="post" action="/signUp">
    <div class="block2">
        <label><input type="text" placeholder="Имя" name="name"></label>Имя<br>
    </div>
    <div class="block2">
        <label><input type="text" placeholder="Фамилия" name="surname"></label>Фамилия<br>
    </div>
    <div class="block2">
        <label><input type="text" placeholder="Номер телефона" name="phone"></label>Номер телефона<br>
    </div>
    <div class="block2">
        <label><input type="password" placeholder="Пароль" name="password"></label>Пароль<br>
    </div>
    <div class="button">
        <input type="submit" value="Зарегистрировать">
    </div>
</form>
</body>
</html>
