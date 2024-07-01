package com.score.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.score.bean.Student;
import com.score.bean.User;

public interface StudentService {

	PageInfo<Student> getAll(Student student,int pageNum,int pageSize);

	Student selectById(int studentId);

	List <Student> selectStudentOfTeacher(int teacherId);
}
