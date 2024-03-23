package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    //教师编号、姓名
    private int teacherId;

    private String name;

    private int classId;

    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                '}';
    }
}
