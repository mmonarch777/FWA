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
      <img class="image" alt="Avatar"
      <c:if test="${user.imageList.size() > 0}">
        src="<c:out value="data:${user.imageList.get(user.imageList.size() - 1).mime};base64,${sessionScope.img}"/>"/>
      </c:if>
      <c:if test="${user.imageList.size() <= 0}">
        src="/"/>
      </c:if>
      <form method="post" action="/profile" enctype="multipart/form-data">
        <div class="upload">
          <label>
            <input type="file" name="file" accept="image/.png,.jpeg"><br/>
            <input type="submit" value="Upload">
          </label>
        </div>
      </form>
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
      <table class="table2">
        <thead>
        <tr>
          <th style="text-align: left">Название файла</th>
          <th style="text-align: left">Размер</th>
          <th style="text-align: left">MIME</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="image" items="${user.imageList}">
          <tr>
            <td>
              <a href="image/<c:out value="${image.uniqName}"/>" target="_blank">
              <c:out value="${image.name}"/>
              </a>
            </td>
            <td>
              <c:set var="size" value="${image.size / 1000}"/>
              <c:choose>
                <c:when test="${size >= 1000}">
                  <fmt:formatNumber value="${size / 1000}" pattern="0.0"/> MB
                </c:when>
                <c:otherwise>
                  <fmt:formatNumber value="${size}" pattern="0"/> KB
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <c:out value="${image.mime}"/>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
  </div>
  </body>
</html>
