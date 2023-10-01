package com.simplilearn.course.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */

@WebServlet("/CookiesServlet")
public class _06_CookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static final String COOKIE_NAME = "user";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        /* Functional Programming */
        String user = Arrays.stream(cookies)
                         .filter(c -> COOKIE_NAME.equals(c.getName()))
                         .map(Cookie::getValue)
                         .findAny().orElse(null);

        boolean remove = Boolean.valueOf(request.getParameter("remove"));

        if (remove) {

            user = null;

            Cookie cookie = new Cookie(COOKIE_NAME,user);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        request.setAttribute("user",user);
        request.getRequestDispatcher("cookies_form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");

        Cookie cookie = new Cookie(COOKIE_NAME,user);

        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/CookiesServlet");
    }
}
