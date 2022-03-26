package com.example.PracticeProjectOne;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", value = "/welcome-servlet")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = (String)request.getSession().getAttribute("UserName");
        response.getWriter().println("Welcome " + userName + "<br><a href='logout-servlet'>Log Out</a>");
    }
}
