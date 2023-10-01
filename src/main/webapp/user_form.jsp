<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
  <h1>HTML Form JSP Class Example</h1>
  <br>
  <form action='FormServlet' method='post'>
    First Name: <input type='text' name='firstname' required>
    <br><br>
    Last Name: <input type='text' name='lastname' required>
    <br><br>
    Email: <input type='email' name='email' required>
    <br><br>
    Birth: <input type='date' name='birth' required>
    <br><br>
    <input type='submit' value='Submit'>
  </form>
</body>
</html>