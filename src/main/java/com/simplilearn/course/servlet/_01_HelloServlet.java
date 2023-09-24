package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class _01_HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Hello World HttpServlet Class Example</h1>");
        printWriter.print("<a href='https://www.google.com/'>Google</a>");
        printWriter.print("</body>");
        printWriter.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
