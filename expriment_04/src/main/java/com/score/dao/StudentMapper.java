package com.score.dao;

import com.score.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    Student selectById(Integer studentId);

    List<Student> selectAll(Student record);

    List<Student> selectByTeacherId(int teacherId);

}