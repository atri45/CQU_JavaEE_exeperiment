package cn.edu.cqu.cs.mapper.impl;

import cn.edu.cqu.cs.CommandTool;
import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.mapper.IStudentDao;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {

    private List<Student> studentList = new ArrayList<Student>();

    @Override
    public long add(Student student) {
        long id = studentList.size() + 1;
        student.setId(id);
        studentList.add(student);
        return studentList.size();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Student find(long id) {

        for(Student student : studentList){
            long studentId = student.getId();
            if(studentId == id){
                return student;
            }
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public long count() {
        return studentList.size();
    }
}
