package com.crud.controller;

import com.crud.model.Student;
import com.crud.service.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int rollno = Integer.parseInt(request.getParameter("txtRollno"));
            String name = request.getParameter("txtName");
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtDOB"));
            Float mark = Float.parseFloat(request.getParameter("txtMark"));
            Student student = new Student(rollno, name, dob, mark);
            StudentDAO sdao = new StudentDAO();
            int result = sdao.updateData(student);
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.println("Record Updated");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
