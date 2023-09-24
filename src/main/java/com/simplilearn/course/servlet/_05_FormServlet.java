package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */

@WebServlet("/FormServlet")
public class _05_FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>HTML Form HttpServlet Class Example</h1>");
        out.print("<br>");
        out.print("<form action='FormServlet' method='post'>");
        out.print("First Name: <input type='text' name='firstname' required>");
        out.print("<br><br>");
        out.print("Last Name: <input type='text' name='lastname' required>");
        out.print("<br><br>");
        out.print("Email: <input type='email' name='email' required>");
        out.print("<br><br>");
        out.print("Birth: <input type='date' name='birth' required>");
        out.print("<br><br>");
        out.print("<input type='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>HTML Form HttpServlet Class Example</h1>");
        out.print("<br>");
        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<th>Field Name</th>");
        out.print("<th>Value</th>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>First Name</td>");
        out.print("<td>" + firstName + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Last Name</td>");
        out.print("<td>" + lastName + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Email</td>");
        out.print("<td>" + email + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Birth</td>");
        out.print("<td>" + birth + "</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<br>");
        out.print("<a href='" + request.getContextPath() + "/FormServlet'>Try Again</a>");
        out.print("</body>");
        out.print("</html>");
    }
}
