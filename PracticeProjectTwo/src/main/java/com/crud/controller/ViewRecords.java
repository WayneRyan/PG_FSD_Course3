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
import java.util.ArrayList;

@WebServlet(name = "ViewRecords", value = "/ViewRecords")
public class ViewRecords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Student> myStudents = new StudentDAO().getRecords();
        PrintWriter out = response.getWriter();
        out.println("<table border=2>");
        for (Student student : myStudents) {
            out.println("<tr><td>" + student.getRollno() + "</td><td>" + student.getStudname() + "</td><td>" + student.getDOB() + "</td><td>" + student.getMark() + "</td>");
            out.println("<td><a href='EditServlet?rollno=" + student.getRollno() + "'>edit</a></td>");
            out.println("<td><a href='DeleteServlet?rollno=" + student.getRollno() + "'>delete</a></td></tr>");
        }
        out.println("</table>");
    }

}
