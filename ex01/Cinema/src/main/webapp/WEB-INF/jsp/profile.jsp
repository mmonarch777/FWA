<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmonarch
  Date: 1/20/23
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      .button {
        width: 320px;
        background: #bbbc99;
        padding: 5px;
        border: solid 1px black;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
      }
    </style>
  </head>
  <body>
  <h1 class="button">Привет <c:out value="${sessionScope.user.name}"/> </h1>
  </body>
</html>
