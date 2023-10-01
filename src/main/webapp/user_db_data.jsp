<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.course.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User DB Data</title>
</head>
<body>
<%
  boolean show = Boolean.valueOf(request.getParameter("show"));
  List<User> users = (List<User>)request.getAttribute("users");
%>
  <h1>DB HttpServlet Class Example</h1>
  <br>
<%
  if (show) {
%>
      <table border='1'>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Username</th>
          <th>Birth</th>
          <th>Status</th>
        </tr>

<%
      for (User user: users) {
%>
        <tr>
          <th><%= user.getIdUser() %></th>
          <th><%= user.getFirstName() + " " + user.getLastName() %></th>
          <th><%= user.getUsername() %></th>
          <th><%= user.getBirth() %></th>
          <th><%= user.getStatus()%></th>
        </tr>
<%
      }
%>
      </table>
      <br>
      <a href='<%= request.getContextPath( )%>/DBServlet'>Try Again</a>
<%
  }
  else {
%>
  <a href='<%= request.getContextPath() %>/DBServlet?show=true'>Show Data</a>
<%
  }
%>
</body>
</html>