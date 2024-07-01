package com.score.service;

import java.util.List;

import com.score.bean.User;

public interface UserService {

	List<User> getStudentUser(User user);

	List<User> getTeacherUser(User user);

	int insertUser(User user);

}
