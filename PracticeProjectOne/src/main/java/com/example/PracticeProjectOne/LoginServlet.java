package com.example.PracticeProjectOne;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName.equalsIgnoreCase("admin") && password.equals("abc123")) {
            request.getSession().setAttribute("UserName", userName);
            request.getRequestDispatcher("welcome-servlet").forward(request, response);
        } else {
            response.getWriter().println("<H3>Invalid username and password.</H3>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }


    }
}
