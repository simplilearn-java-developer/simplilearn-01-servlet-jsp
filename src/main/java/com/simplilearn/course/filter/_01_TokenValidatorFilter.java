package com.simplilearn.course.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class _01_TokenValidatorFilter
 */
public class _01_TokenValidatorFilter extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        System.out.println("TokenValidatorFilter Running");

        String token = request.getParameter("token");

        String method =((HttpServletRequest)request).getMethod();

        System.out.println("Request Method: " + method);

        if ("POST".equals(method) && token.trim().isEmpty()) {
            /*
             * If the token is not present or empty, we display an
             * error message to the user and the request doesn't
             * reach the server.
             */
            out.print("<html>");
            out.print("<body>");
            out.print("<h1>HTML Filter <span style='color:red'>HttpFilter</span> Class Example</h1>");
            out.print("<br>");
            out.print("<h2 style='color:red'>Intercepted - Token was not Found!</h2>");
            out.print("<br><br>");
            out.print("<a href='" + ((HttpServletRequest)request).getContextPath() + "/TokenServlet'>Try Again</a>");
            out.print("</body>");
            out.print("</html>");
        }
        else {
            /*
             * If all is good, continue processing the rest of the filters.
             */
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
    }

}
