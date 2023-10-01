<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header Info</title>
</head>
<body>
  <h1>Header Info HttpServlet Class Example</h1>
  <br>
  <%
    Iterator<String> ite = request.getHeaderNames().asIterator();
    while (ite.hasNext()) {
        String name = ite.next();
  %>
        <h2><%= name %> : <%= request.getHeader(name)%> </h2>
  <%
    }
  %>
  <h2>Host: <%= request.getHeader("host")%></h2>
  <h2>Platform: <%= request.getHeader("sec-ch-ua-platform")%></h2>
  <h2>Agent: <%= request.getHeader("user-agent") %></h2>
</body>
</html>