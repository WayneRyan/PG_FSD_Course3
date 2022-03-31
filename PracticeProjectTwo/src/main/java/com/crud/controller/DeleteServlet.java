package com.crud.controller;

import com.crud.service.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int result = new StudentDAO().deleteStudentByRollno(rollno);
        if (result > 0) {
            response.getWriter().println("Record Deleted");
        }
    }
}
