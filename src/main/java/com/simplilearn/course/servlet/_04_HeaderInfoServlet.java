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

        System.out.println("host: " + host);
        System.out.println("platform: " + platform);
        System.out.println("agent: " + agent);

        request.getRequestDispatcher("header_info.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
