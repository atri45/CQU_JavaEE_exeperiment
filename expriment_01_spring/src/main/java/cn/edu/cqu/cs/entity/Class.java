package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    //教学班号、课程id、总人数、开课学期
    private int classId;

    private int courseId;

    private int studentNum;

    private int openSemester;

    public void addStudent() {
        this.studentNum++;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", courseId=" + courseId +
                ", studentNum=" + studentNum +
                ", openSemester=" + openSemester +
                '}';
    }
}
