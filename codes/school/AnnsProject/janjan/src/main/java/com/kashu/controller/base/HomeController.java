package com.kashu.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public ModelAndView home(){
		   ModelAndView mv = new ModelAndView();
      mv.addObject("message", "Hello Reader!");
      mv.setViewName("home");
      return mv;
	}
	
	@RequestMapping(value = "/part")
	public ModelAndView part(){
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("message", "I am part.jsp 噗");
		   mv.setViewName("part");
		   return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("title", "林爸是/login.jsp的title");
		   mv.addObject("message", "I am login.jsp 我噗");
		   mv.setViewName("login");
		   return mv;
	}
	
}