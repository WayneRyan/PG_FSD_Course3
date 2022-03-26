package com.example.Tomcat9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uname=null;
        for (Cookie cookie: request.getCookies()) {
            if(cookie.getName().equals("Username")){
                uname = cookie.getValue().trim();
            }
        }
//        HttpSession session = request.getSession(false);
//        String uname = (String)session.getAttribute("Username");
        PrintWriter out = response.getWriter();
        out.println("Welcome "+uname);
        out.println("<a href='LogoutServlet>Log out</a>");
    }
}
