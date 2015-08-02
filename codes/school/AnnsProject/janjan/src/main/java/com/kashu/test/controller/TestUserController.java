package com.kashu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kashu.test.domain.User;
import com.kashu.test.service.UserService;

@Controller
@RequestMapping("/user01")
public class TestUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/alluser")
	public String listAllUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "test/testuser01";
	}
	
	@RequestMapping("/add")
	public String addUser(Model model){
		User user = new User("sakura","sakurapass","sakura@gmail.com");
		User result = userService.save(user);
		model.addAttribute("user",result);
		return "test/adduser01";
	}
	
	@RequestMapping("/update")
	public String updateUser(Model model){
		User user = new User("sakura","xxxxxxxx","yyyyyyyy");
		User result = userService.update(user);
		model.addAttribute("user",result);
		return "test/updateuser01";
	}
	
	@RequestMapping("/get")
	public String getUser(@RequestParam(value="username",required=false) String username, Model model){
		User result = userService.findByUsername(username);
		model.addAttribute("user", result);
		return "test/getuser01";
	}
}
