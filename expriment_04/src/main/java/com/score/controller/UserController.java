package com.score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.score.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.score.bean.ResultObject;
import com.score.bean.User;
import com.score.service.UserService;
import com.score.service.StudentService;
import com.score.util.Constant;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;
	
    
    @RequestMapping("/teacherLogin")
    public ResultObject<List<User>> teacherLogin(User user,HttpServletRequest request) {
    	List<User> list= userService.getTeacherUser(user);
    	ResultObject<List<User>> rs=new ResultObject<List<User>>();
    	if(list.isEmpty()) {
        	rs.setCode(Constant.FAILURE_RETUEN_CODE);
        	rs.setMsg("Login unsuccessfully");
    	}else {
        	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        	request.getSession().setAttribute("teacher", teacherService.selectById(list.get(0).getUserId()));
        	rs.setMsg("Login successfully");
    	}
    	rs.setData(list);
        return rs;
    }

	@RequestMapping("/teacherSignup")
	public ResultObject<Object> teacherSignup(User user) {
		user.setIsTeacher(1);
		int total=userService.insertUser(user);
		ResultObject<Object> rs=new ResultObject<Object>();
		if(0==total) {
			rs.setCode(Constant.FAILURE_RETUEN_CODE);
			rs.setMsg("Insert unsuccessfully");
		}else {
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
			rs.setMsg("Insert successfully");
		}
		return rs;
	}

    @RequestMapping("/logout")
    public ResultObject<Object> logout(HttpServletRequest request) {
    	ResultObject<Object> rs=new ResultObject<Object>();
    	request.getSession().removeAttribute("teacher");
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("Logout successfully");
        return rs;
    }

    @RequestMapping("/studentLogin")
    public ResultObject<List<User>> studentLogin(User user,HttpServletRequest request) {
    	List<User> list= userService.getStudentUser(user);
    	ResultObject<List<User>> rs=new ResultObject<List<User>>();
    	if(list.isEmpty()) {
        	rs.setCode(Constant.FAILURE_RETUEN_CODE);
        	rs.setMsg("Login unsuccessfully");
    	}else {
        	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        	request.getSession().setAttribute("student", studentService.selectById(list.get(0).getUserId()));
        	rs.setMsg("Login successfully");
    	}
    	rs.setData(list);
        return rs;
    }
    @RequestMapping("/studentLogout")
    public ResultObject<Object> studentLogout(HttpServletRequest request) {
    	ResultObject<Object> rs=new ResultObject<Object>();
    	request.getSession().removeAttribute("student");
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("Logout successfully");
        return rs;
    }

	@RequestMapping("/studentSignup")
	public ResultObject<Object> studentSignup(User user) {
		user.setIsTeacher(0);
		int total=userService.insertUser(user);
		ResultObject<Object> rs=new ResultObject<Object>();
		if(0==total) {
			rs.setCode(Constant.FAILURE_RETUEN_CODE);
			rs.setMsg("Insert unsuccessfully");
		}else {
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
			rs.setMsg("Insert successfully");
		}
		return rs;
	}
}
