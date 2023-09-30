package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/TokenServlet")
public class _08_TokenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>HTML Token HttpServlet Class Example</h1>");
        out.print("<br>");
        out.print("<form action='TokenServlet' method='post'>");
        out.print("Token: <input type='text' name='token'>");
        out.print("<br><br>");
        out.print("<input type='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String token = request.getParameter("token");

        if (token != null && !token.trim().isEmpty()) {
            out.print("<html>");
            out.print("<body>");
            out.print("<h1>HTML Token HttpServlet Class Example</h1>");
            out.print("<br>");
            out.print("<h2 style='color:green'>Token was Found!</h2>");
            out.print("<h3>Token: " + token + "</h3>");
            out.print("<br><br>");
            out.print("<a href='" + request.getContextPath() + "/TokenServlet'>Try Again</a>");
            out.print("</body>");
            out.print("</html>");
        }
        else {
            out.print("<html>");
            out.print("<body>");
            out.print("<h1>HTML Token HttpServlet Class Example</h1>");
            out.print("<br>");
            out.print("<h2 style='color:red'>Token was not Found!</h2>");
            out.print("<br><br>");
            out.print("<a href='" + request.getContextPath() + "/TokenServlet'>Try Again</a>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
