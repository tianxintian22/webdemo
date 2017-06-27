package com.test.webdemo.service;

import java.util.List;

import com.test.webdemo.model.Users;

public interface UserService {
	Users getUser(Integer userId);
	List<Users> query();
	List<Users> query(String name);
	void addUser(Users u);
	void updateUser(Users u);
	void delUser(Integer id);
	
	
}
