package com.crud.service;

import com.crud.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private static Connection getConnection() {
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

    public int insertData(Student student) {
        int result = 0;
        try {
            Connection con = getConnection();
            java.sql.Date dob = new java.sql.Date(student.getDOB().getTime());
            PreparedStatement ps = con.prepareStatement("insert into studentdetails (rollno, sdudname, dob, marks) values (?, ?, ?, ?)");
            ps.setInt(1, student.getRollno());
            ps.setString(2, student.getStudname());
            ps.setDate(3, dob);
            ps.setFloat(4, student.getMark());
            result = ps.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public ArrayList<Student> getRecords() {
        ArrayList<Student> retVal = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from studentdetails");
            while (rs.next()) {
                retVal.add(new Student(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getFloat(4)));
            }
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retVal;
    }

    public Student getStudentByRollno(int rollno) {
        Student retVal = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from studentdetails where rollno=?");
            ps.setInt(1, rollno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retVal = new Student(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getFloat(4));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retVal;
    }

    public int updateData(Student student) {
        int result = 0;
        try {
            Connection con = getConnection();
            java.sql.Date dob = new java.sql.Date(student.getDOB().getTime());
            PreparedStatement ps = con.prepareStatement("update studentdetails set sdudname=?, dob=?, marks=? where rollno=?");
            ps.setString(1, student.getStudname());
            ps.setDate(2, dob);
            ps.setFloat(3, student.getMark());
            ps.setInt(4, student.getRollno());
            result = ps.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public int deleteStudentByRollno(int rollno) {
        int result = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from studentdetails where rollno=?");
            ps.setInt(1, rollno);
            result = ps.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
