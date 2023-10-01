<%@ page import="com.simplilearn.course.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User DB Data</title>
</head>
<body>

  <jsp:useBean id="show" scope="request" type="java.lang.Boolean" />
  <jsp:useBean id="users" scope="request" type="java.util.List<User>" />

  <c:set var="context" value="${pageContext.request.contextPath}"/>

  <h1>DB HttpServlet Class Example</h1>
  <br>

  <c:if test="${show}">

      <table border='1'>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Username</th>
          <th>Birth</th>
          <th>Status</th>
        </tr>

        <c:forEach var="user" items="${users}">
          <tr>
            <th>${ user.idUser }</th>
            <th>${ user.firstName } ${ user.lastName }</th>
            <th>${ user.username }</th>
            <th>${ user.birth }</th>
            <th>${ user.status }</th>
          </tr>
        </c:forEach>

      </table>
      <br>
      <a href='${context}/DBServlet'>Try Again</a>
  </c:if>
  <c:if test="${!show}">
    <a href='${context}/DBServlet?show=true'>Show Data</a>
  </c:if>

</body>
</html>