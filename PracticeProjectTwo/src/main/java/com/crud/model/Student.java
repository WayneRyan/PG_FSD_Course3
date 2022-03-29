package com.crud.model;

import java.util.Date;

public class Student {
    private int rollno;
    private String studname;
    private Date DOB;
    private float mark;

    public Student(int rollno, String studname, Date DOB, float mark) {
        this.rollno = rollno;
        this.studname = studname;
        this.DOB = DOB;
        this.mark = mark;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
