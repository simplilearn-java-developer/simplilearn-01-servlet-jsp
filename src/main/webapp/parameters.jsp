<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameters JSP</title>
</head>
<body>

  <% 
     String firstName = request.getParameter("firstname");
     String lastName = request.getParameter("lastname");  
  %>

  <h1>Parameters HttpServlet Class Example</h1>
  <br>
  <h2>First Name: <%= firstName %> </h2>
  <h2>Last Name: <%= lastName %> </h2>
</body>
</html>