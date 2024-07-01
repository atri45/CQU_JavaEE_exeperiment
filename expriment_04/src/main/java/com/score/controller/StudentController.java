package com.score.controller;

import java.util.List;

import com.score.bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.score.bean.ResultObject;
import com.score.bean.Student;
import com.score.service.StudentService;
import com.score.util.Constant;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	  
    @RequestMapping("/getAllStudent")
    public ResultObject<List<Student>> getUsers(Student student,@RequestParam("limit") int limit,@RequestParam("page") int page) {
    	PageInfo<Student> pageInfo=studentService.getAll(student, page, limit);
    	ResultObject<List<Student>> rs=new ResultObject<List<Student>>();
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("Query successfully");
    	rs.setData(pageInfo.getList());
    	rs.setCount(pageInfo.getTotal());
    	return rs;
    }

    @RequestMapping("/studentSelect")
    public ResultObject<List<Student>> studentSelect(HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
    	ResultObject<List<Student>> rs=new ResultObject<List<Student>>();
    	List<Student> list=studentService.selectStudentOfTeacher(teacher.getTeacherId());
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("Query successfully");
    	rs.setData(list);
    	int total=list.size();
    	Long a=Long.parseLong(String.valueOf(total));
    	rs.setCount(a);
    	return rs;
    }
    
}
