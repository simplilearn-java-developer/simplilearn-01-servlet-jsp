package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.course.bean.User;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/DBServletById")
public class _10_DBServletById extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>DB HttpServlet Class Example</h1>");
        out.print("<br>");
        out.print("<h2>Input a User ID</h2>");
        out.print("<form action='DBServletById' method='post'>");
        out.print("Id: <input type='text' name='id' required>");
        out.print("<br><br>");
        out.print("<input type='submit' value='Submit'>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        User user = loadUser(id);

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>DB HttpServlet Class Example</h1>");
        out.print("<br>");

        if (user!= null) {

            out.print("<table border='1'>");
            out.print("<tr>");
            out.print("<th>Field Name</th>");
            out.print("<th>Value</th>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Id</td>");
            out.print("<td>" + user.getIdUser() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Name</td>");
            out.print("<td>" + user.getFirstName() + " " + user.getLastName() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Username</td>");
            out.print("<td>" + user.getUsername() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Birth</td>");
            out.print("<td>" + user.getBirth() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Status</td>");
            out.print("<td>" + user.getStatus() + "</td>");
            out.print("</tr>");
            out.print("</table>");
            out.print("<br>");
            out.print("<a href='" + request.getContextPath() + "/DBServletById'>Search Again</a>");
        }
        else {
            out.print("<h2 style='color:red'>User Id: " + id + " not Found!</h2>");
            out.print("<br><br>");
            out.print("<a href='" + request.getContextPath() + "/DBServletById'>Search Again</a>");
       }

        out.print("</body>");
        out.print("</html>");
    }

    private User loadUser(String id){

        User user = null;

        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUsername = "root";
        String dbPassword = "rootroot";

        /*
         * Create the Select SQL Statement
         */
        String sql = "SELECT * FROM USER WHERE ID_USER = ?";

        System.out.println("Query: " + sql);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            PreparedStatement prSt = con.prepareStatement(sql);) {

            prSt.setString(1, id); // Replace the placeholder with the input we collected before.

            try(ResultSet rs = prSt.executeQuery()){

                user = this.createUser(id, rs);
            }

        } catch (SQLException ex) {

            System.err.println("Error while accessing the DB! , " + ex.getSQLState() + ", " + ex.getMessage());
        }

        return user;
    }

    private User createUser(String id, ResultSet rs) throws SQLException {

        User user = null;

        if (rs.next()) {

            user = new User();

            int idUser = rs.getInt("ID_USER");
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            String firstName = rs.getString("FIRST_NAME");
            String lastName = rs.getString("LAST_NAME");
            Date birth = rs.getDate("BIRTH");
            String status = rs.getString("STATUS");

            /*
             * Populate a User object.
             */
            user.setIdUser(idUser);
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setBirth(birth);
            user.setStatus(status);

            System.out.println("User found!!, User ID: " + id);
        }
        else {
            System.out.println("User not found, User ID: " + id);
        }

        return user;
    }
}
