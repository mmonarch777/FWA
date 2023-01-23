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
    <style>
      table, th, td {
        border: 1px solid black;
      }
      .head {
        display: flex;
        max-width: 100%;
        height: auto;
      }
      .block1 {
        margin-left: 20px;
        margin-top: 20px;
      }
      .block2 {
        margin-left: 20px;
      }
    </style>
  </head>
  <body>
  <div class="head">
    <div class="block1">
      <img style="width:auto;" alt="Avatar" width="200" height="200"/>
    </div>
    <div class="block2">
      <h1>${user.name} ${user.surname}</h1>
      <p>Phone: ${user.phone}</p>
      <table style="width: 500px">
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
              <fmt:formatDate value="${info.date}" pattern="dd.MM.yyyy"/>
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
  </body>
</html>
