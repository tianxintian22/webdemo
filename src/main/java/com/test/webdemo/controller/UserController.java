package com.test.webdemo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute(user);
		model.addAttribute("username",user.getUser_name());
		return "user_view";
	}
	@RequestMapping("/view2/{userId}")
	public String viewUser2(@PathVariable("userId") Integer userId, Map<String, Object> model) {
		log.debug("In viewUser, courseId={}", userId);
		Users user = userService.getUser(userId);
		model.put("user", user);
		return "user_view";
	}
	@RequestMapping("/view/userlist")
	public String viewUserList(Map<String, Object> model) {
		log.debug("In viewUser, query");
		List<Users> users = userService.query();
		model.put("userList", users);
		return "user_view";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
	public String viewUserAdd() {
		return "userAdd";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String doSave(Users user) {
		user.setCreate_user("admin");
		user.setUpdate_user("admin");
		user.setBirthday(new Date());
		user.setIsdel(0);
		userService.addUser(user);
		return "redirect:view/userlist";
	}
	@RequestMapping(value="/view/search", method=RequestMethod.POST)
	public String doSave(String user_name, Map<String, Object> model) {
		List<Users> user = userService.query(user_name);
		model.put("userList", user);
		model.put("user_name", user_name);
		return "user_view";
	}

	
	
}
