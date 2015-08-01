package com.kashu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
