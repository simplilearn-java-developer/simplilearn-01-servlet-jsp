<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Table</title>
</head>
<body>
  <h1>HTML Form JSP Class Example</h1>
  <br>
  <table border='1'>
    <tr>
      <th>Field Name</th>
      <th>Value</th>
    </tr>
    <tr>
      <td>First Name</td>
      <td><%= request.getParameter("firstname") %></td>
    </tr>
    <tr>
      <td>Last Name</td>
      <td><%= request.getParameter("lastname") %></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><%= request.getParameter("email") %></td>
    </tr>
    <tr>
      <td>Birth</td>
      <td><%= request.getParameter("birth") %></td>
    </tr>
  </table>
  <br>
  <a href='<%=request.getContextPath()%>/FormServlet'>Try Again</a>
</body>
</html>