package com.kashu.controller.base;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kashu.domain.User;

@Controller
@SessionAttributes({"currentURL"})
public class HomeController {

	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response){
		   ModelAndView mv = new ModelAndView();
      mv.addObject("message", "Hello Reader!");
      mv.addObject("currentURL", "/home");
      response.addCookie(new Cookie("cookie_currentURL","/home"));
      mv.setViewName("home");
      return mv;
	}
	
		/*
		public String rrregister_form(Model model){
			User user = new User();
			model.addAttribute("user", user);
			return "users/register";
		}
		*/
	
	@RequestMapping(value = "/part")
	public ModelAndView part(){
		   ModelAndView mv = new ModelAndView();
		   mv.addObject("message", "I am part.jsp 噗");
		   mv.setViewName("part");
		   return mv;
	}
	
	@RequestMapping(value = "/user_only")
	public ModelAndView user_only(HttpServletRequest request, HttpServletResponse response){
		   ModelAndView mv = new ModelAndView();
		   //mv.addObject("title", "林爸是/user_only.jsp的title");
		   mv.addObject("message", "I am user_only.jsp 我噗我噗");
		   mv.addObject("currentURL", "/user_only");
		   response.addCookie(new Cookie("cookie_currentURL","/user_only"));
		   mv.setViewName("user_only");
		   return mv;
	}
	
}
