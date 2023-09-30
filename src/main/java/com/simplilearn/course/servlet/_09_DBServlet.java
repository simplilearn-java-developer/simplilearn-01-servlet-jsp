package com.simplilearn.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.course.bean.User;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/DBServlet")
public class _09_DBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        boolean show = Boolean.valueOf(request.getParameter("show"));

        out.print("<html>");
        out.print("<body>");
        out.print("<h1>DB HttpServlet Class Example</h1>");
        out.print("<br>");
        if (show) {

            List<User> users = this.loadUsers();

            out.print("<table border='1'>");
            out.print("<tr>");
            out.print("<th>Id</th>");
            out.print("<th>Name</th>");
            out.print("<th>Username</th>");
            out.print("<th>Birth</th>");
            out.print("<th>Status</th>");
            out.print("</tr>");

            for (User user: users) {
                out.print("<tr>");
                out.print("<th>" + user.getIdUser()+ "</th>");
                out.print("<th>" + user.getFirstName() + " " + user.getLastName() + "</th>");
                out.print("<th>" + user.getUsername() + "</th>");
                out.print("<th>" + user.getBirth() + "</th>");
                out.print("<th>" + user.getStatus()+ "</th>");
                out.print("</tr>");
            }

            out.print("</table>");
            out.print("<br>");
            out.print("<a href='" + request.getContextPath() + "/DBServlet'>Try Again</a>");

        }
        else {
            out.print("<a href='" + request.getContextPath() + "/DBServlet?show=true'>Show Data</a>");
        }

        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    List<User> loadUsers(){

        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUsername = "root";
        String dbPassword = "rootroot";

        List<User> users = new ArrayList<>();

        /*
         * Create the Select SQL Statement
         */
        String sql = "SELECT * FROM USER";

        System.out.println("Query: " + sql);

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        /*
         * Get data from the DB table;
         */
        try(Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            /*
             * Note that the Connection, Statement and the ResultSet are closed
             * automatically by the try() with resources.
             */


            while (rs.next()) {

                int idUser = rs.getInt("ID_USER");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                Date birth = rs.getDate("BIRTH");
                String status = rs.getString("STATUS");

                /*
                 * Create and populate a User object.
                 */
                User user = new User();
                user.setIdUser(idUser);
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirth(birth);
                user.setStatus(status);

                /*
                 * Add the user to the users list
                 */
                users.add(user);
            }

            System.out.println("Number of rows retrieved: " + users.size());
        } catch (SQLException ex) {

            System.err.println("Error while accessing the DB! , " + ex.getSQLState() + ", " + ex.getMessage());
        }

        users.forEach(System.out::println);

        return users;
    }
}
