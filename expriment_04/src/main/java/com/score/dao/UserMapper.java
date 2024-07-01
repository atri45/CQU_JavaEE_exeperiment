package com.score.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.score.bean.User;

@Mapper
public interface UserMapper {
	List<User> getStudentUser(User user);

	List<User> getTeacherUser(User user);

	int insertUser(User user);
}
