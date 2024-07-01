package com.score.bean;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int userId;

	private int pass;

	private int isTeacher;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getIsTeacher() {
		return isTeacher;
	}

	public void setIsTeacher(int isTeacher) {
		this.isTeacher = isTeacher;
	}
}
