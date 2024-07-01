package com.score.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.score.bean.User;
import com.score.dao.UserMapper;
import com.score.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getStudentUser(User user) {
		return userMapper.getStudentUser(user);
	}

	public List<User> getTeacherUser(User user) {
		return userMapper.getTeacherUser(user);
	}

	public int insertUser(User user){return userMapper.insertUser(user);}

}
