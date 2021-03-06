package com.example.DatabasePractice;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    private static Connection getConnection(){
        Connection con = null;
        try {
            System.out.println("Loading driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/cred", "root", "Oitnommc3.");
            System.out.println("Connection is" + (con == null ? "null" : "not null"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from studentdetails");
            // Hello
            PrintWriter out = response.getWriter();
            out.println("<table border=2>");
            while (rs.next()){
                out.println("<tr><td>" + rs.getInt("rollno") + "</td><td>" + rs.getString("sdudname") + "</td><td>" + rs.getDate("dob") + "</td><td>" + rs.getFloat("marks") + "</td></tr>");
            }
            out.println("</table>");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throwables.printStackTrace();
        }

    }

    public void destroy() {
    }
}