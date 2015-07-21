package com.kashu.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request){
		   ModelAndView mv = new ModelAndView();
		   String targetUrl = getRememberMeTargetUrlFromSession(request);
      mv.addObject("message", "Hello Reader!");
      mv.addObject("targetUrl",targetUrl);
      System.out.println("targetUrl=" + targetUrl);
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
	
	@RequestMapping(value = "/user_only")
	public ModelAndView user_only(HttpServletRequest request){
		   ModelAndView mv = new ModelAndView();
		   String targetUrl = getRememberMeTargetUrlFromSession(request);
		   mv.addObject("title", "林爸是/user_only.jsp的title");
		   mv.addObject("message", "I am user_only.jsp 我噗我噗");
		   mv.addObject("targetUrl",targetUrl);
		   System.out.println("targetUrl=" + targetUrl);
		   mv.setViewName("user_only");
		   //記得把targetURL放進來
		   return mv;
	}
	
	/**
	 * save targetURL in session
	 */
	private void setRememberMeTargetUrlToSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.setAttribute("targetUrl", "/home");
		}
	}

	/**
	 * get targetURL from session
	 */
	private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if(session!=null){
			targetUrl = session.getAttribute("targetUrl")==null?"":session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}
	
}
