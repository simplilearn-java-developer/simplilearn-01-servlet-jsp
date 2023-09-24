package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParametersServlet
 */

@WebServlet("/HeaderInfoServlet")
public class _04_HeaderInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String host = request.getHeader("host");
        String platform = request.getHeader("sec-ch-ua-platform");
        String agent = request.getHeader("user-agent");

        /*
         * Get the list of existing Headers from the request object
         */
        /*
         Iterator<String> ite = request.getHeaderNames().asIterator();
         while (ite.hasNext()) {
            String name = ite.next();
            System.out.println( name + " " + request.getHeader(name));
         }
         */

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>Header Info HttpServlet Class Example</h1>");
        out.print("<br>");

        Iterator<String> ite = request.getHeaderNames().asIterator();
        while (ite.hasNext()) {
            String name = ite.next();
            out.print("<h2>" + name + ": " + request.getHeader(name) + "</h2>");
        }

        /*
        out.print("<h2>Host: " + host + "</h2>");
        out.print("<h2>Platform: " + platform + "</h2>");
        out.print("<h2>Agent: " + agent + "</h2>");*/
        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
