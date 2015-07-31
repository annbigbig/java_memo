package com.kashu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping(value="/invalid-session")
	public String invalid(){
		System.out.println("SessionController.invalid() was called !");
		return "home";
	}
	
	@RequestMapping(value="/expired-session")
	public String expired(){
		System.out.println("SessionController.expired() was called !");
		return "home";
	}
}
