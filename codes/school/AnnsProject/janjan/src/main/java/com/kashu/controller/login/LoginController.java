package com.kashu.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	/**
	 * both "normal login" and "login for update" shared this form.
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		/*
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
			
			//login form for update, if login error, get the targetUrl from session again.
			String targetUrl = getRememberMeTargetUrlFromSession(request);
			System.out.println("targetUrl=" + targetUrl);

			if(StringUtils.hasText(targetUrl)){
				model.addObject("targetUrl", targetUrl);
				model.addObject("loginUpdate", true);
			}
			
		}
		*/

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		//model.addObject("title", "林爸是/login.jsp的title");
		model.setViewName("login");
		System.out.println("LoginController.login() being called");
		return model;

	}
	
	//登入錯誤之後，Spring Security呼叫此函式
	@RequestMapping(value = "/login_err", method = {RequestMethod.GET,RequestMethod.POST})
	public String login_err(Model model,HttpServletRequest request){
		setLoginErrorMessageToSession(request);
		//return "home";
		return "redirect:/user_only";
	}
	
	@RequestMapping(value = "/login_erro", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login_erro(){
		ModelAndView model = new ModelAndView();
		model.addObject("error", "帳號或密碼錯誤");
		model.setViewName("home");
		return model;
	}
	
	private void setLoginErrorMessageToSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.setAttribute("error_message_in_session", "帳號或密碼錯誤(此錯誤訊息放在session)");
		}		
	}
	
	/**
	 * If the login in from remember me cookie, refer
	 * org.springframework.security.authentication.AuthenticationTrustResolverImpl
	 */
	private boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}
	
	/**
	 * save targetURL in session
	 */
	private void setRememberMeTargetUrlToSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.setAttribute("targetUrl", "/admin/update");
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
