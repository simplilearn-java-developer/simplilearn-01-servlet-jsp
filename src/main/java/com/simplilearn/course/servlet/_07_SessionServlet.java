package com.simplilearn.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionServlet
 */

@WebServlet("/SessionServlet")
public class _07_SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static final String USERNAME = "username";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        boolean logout = Boolean.valueOf(request.getParameter("logout"));

        if (logout) {
            request.getSession(false).invalidate();
        }

        request.getRequestDispatcher("session_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean error = false;

        if ("123".equals(password)) {

            request.getSession().setAttribute(USERNAME, username);
        }
        else {
            error = true;
        }

        response.sendRedirect(request.getContextPath() + "/SessionServlet?error=" + error);
    }
}
