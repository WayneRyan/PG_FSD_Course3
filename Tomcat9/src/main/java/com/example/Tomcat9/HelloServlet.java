package com.example.Tomcat9;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("txtuname");
        String pword = req.getParameter("txtpword");
        if (userName.equalsIgnoreCase("admin") && pword.equals("admin@123")){
            Cookie ck = new Cookie("Username", userName);
            resp.addCookie(ck);
//            HttpSession session = req.getSession(true);
//            session.setAttribute("Username", userName);
            RequestDispatcher rd = req.getRequestDispatcher("WelcomeServlet");
            rd.forward(req, resp);
        } else {
            out.println("<h3>invalid username and Passowrd</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }

    public void destroy() {
    }
}