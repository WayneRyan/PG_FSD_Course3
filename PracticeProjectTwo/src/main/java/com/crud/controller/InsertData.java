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

@WebServlet(name = "InsertData", value = "/InsertData")
public class InsertData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int rollNumber = Integer.parseInt(request.getParameter("txtRollNumber"));
            String name = request.getParameter("txtRollNumber");
            Date dob = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("txtDOB"));
            float mark = Float.parseFloat(request.getParameter("txtMark"));
            Student student = new Student(rollNumber, name, dob, mark);
            StudentDAO sdao = new StudentDAO();
            int result = sdao.insertData(student);
            PrintWriter out = response.getWriter();
            if (result>0){
                out.println("Record inserted");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
