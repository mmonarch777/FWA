<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mmonarch
  Date: 1/20/23
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" type="edu.school21.cinema.models.User"/>
<html>
  <head>
    <title>$Title$</title>
<%--    Не работает тег link--%>
<%--    <link href="../css/index.css" rel="stylesheet" type="text/css"/>--%>
    <style><%@include file="../css/index.css"%></style>
  </head>
  <body>
  <div class="head">
    <div class="block1">
      <img class="image" alt="Avatar"/>
    </div>
    <div class="block2">
      <h1>${user.name} ${user.surname}</h1>
      <p>Phone: ${user.phone}</p>
      <table class="table">
        <thead >
        <tr>
          <th style="text-align:left">Дата</th>
          <th style="text-align:left">Время</th>
          <th style="text-align:left">IP</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="info" items="${user.infoList}">
          <tr>
            <td>
              <fmt:formatDate value="${info.date}" pattern="MMMM dd, yyyy"/>
            </td>
            <td>
              <fmt:formatDate value="${info.date}" pattern="HH:mm"/>
            </td>
            <td>
              <c:out value="${info.ip}"/>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="middle">
    <div class="block2">
      <p>HELLO</p>
    </div>
  </div>
  </body>
</html>
