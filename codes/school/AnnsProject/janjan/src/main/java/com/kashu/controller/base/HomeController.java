package com.kashu.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"currentURL"})
public class HomeController {

	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request){
		   ModelAndView mv = new ModelAndView();
      mv.addObject("message", "Hello Reader!");
      mv.addObject("currentURL", "/home");
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
		   System.out.println("HomeController.login() being called");
		   return mv;
	}
	
	@RequestMapping(value = "/user_only")
	public ModelAndView user_only(HttpServletRequest request){
		   ModelAndView mv = new ModelAndView();
		   //mv.addObject("title", "林爸是/user_only.jsp的title");
		   mv.addObject("message", "I am user_only.jsp 我噗我噗");
		   mv.addObject("currentURL", "/user_only");
		   mv.setViewName("user_only");
		   return mv;
	}
	
}
