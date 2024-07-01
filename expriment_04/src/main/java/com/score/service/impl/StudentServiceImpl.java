package com.score.service.impl;

import java.util.List;

import com.score.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.score.bean.Student;
import com.score.dao.StudentMapper;
import com.score.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Student> getAll(Student student,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Student> list = studentMapper.selectAll(student);
		PageInfo<Student> pageInfo=new PageInfo<Student>(list);
		return pageInfo;
	}

	public Student selectById(int studentId) {
		Student student=studentMapper.selectById(studentId);
		return student;
	}

	public List <Student> selectStudentOfTeacher(int teacherId){return studentMapper.selectByTeacherId(teacherId);};
}
