<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Form</title>
</head>
<body>

<!-- Declaration Tag -->
<%! final String USERNAME = "username"; %>

<!-- Scriplet Tag -->
<%
   String username = (String)request.getSession().getAttribute(USERNAME);

   boolean error = Boolean.valueOf(request.getParameter("error"));

   if (username == null) {
%>
      <h1>Session HttpServlet Class Example</h1>
      <br>
      <% if (error) { %>
          <h3 style='color:red'>Invalid Password!</h3>
      <% } %>
      <h2>Input your Login Info:</h2>
      <br>
      <form action='SessionServlet' method='post'>
        Username: <input type='text' name='username' required>
        <br><br>
        Password: <input type='password' name='password' required>
        <br><br>
        <input type='submit' value='Submit'>
      </form>
<%
   }
   else {
%>
       <h1>Session HttpServlet Class Example</h1>
       <br>
       <!-- Expression Tag -->
       <h2>Welcome <%= username %></h2>
       <br>
       <a href='<%=request.getContextPath()%>/SessionServlet?logout=true'>Logout</a>&nbsp;&nbsp;
       <a href='<%=request.getContextPath()%>/SessionServlet'>Refresh</a>
<%
   }
%>


</body>
</html>