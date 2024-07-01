package com.score.bean;

import org.springframework.stereotype.Component;

@Component
public class Class {
    private int classId;

    private String courseName;

    private int teacherId;

    private int studentNum;

    private int openSemester;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getOpenSemester() {
        return openSemester;
    }

    public void setOpenSemester(int openSemester) {
        this.openSemester = openSemester;
    }
}
