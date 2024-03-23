package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Data 注解在类，生成 setter and getter、equals、hashCode、toString 等方法，
 * 如为final属性，则不会为该属性生成setter方法。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //学号、姓名、性别、年级、班级id、课程id
    private int studentId;

    private String name;

    private String sex;

    private int grade;

    private List<Integer> classId;

    private List<Integer> courseId;

    public Student(int studentId, String name, String sex, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }

    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                ", classId=" + classId +
                ", courseId=" + courseId +
                '}';
    }
}
