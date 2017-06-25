package com.test.webdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.webdemo.model.Users;
import com.test.webdemo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	//日志
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//将处理/users/view?userId=1
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewUser(@RequestParam("userId") Integer userId, Model model) {
		log.debug("In viewUser, courseId={}", userId);
		Users user = userService.getUser(userId);
		System.out.println(user.toString());
		model.addAttribute(user);
		model.addAttribute("username",user.getUser_name());
		return "user_view";
	}

	
	
}
