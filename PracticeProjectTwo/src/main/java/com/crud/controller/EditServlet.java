package com.crud.controller;

import com.crud.model.Student;
import com.crud.service.StudentDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        Student student = new StudentDAO().getStudentByRollno(rollno);
        PrintWriter out = response.getWriter();
        if (student != null) {
            out.println("<form action='UpdateServlet'>");
            out.println("<input type='hidden' name='txtRollno' value='" + student.getRollno() + "'>");
            out.println("<input type='text' name='txtName' value='" + student.getStudname() + "'>");
            out.println("<input type='date' name='txtDOB' value='" + student.getDOB() + "'>");
            out.println("<input type='number' name='txtMark' _min='0' _max='100' _step='0.01' value='" + student.getMark() + "'>");
            out.println("<input type='submit' value='Update'>");
            out.println("</form>");
        }

    }
}
