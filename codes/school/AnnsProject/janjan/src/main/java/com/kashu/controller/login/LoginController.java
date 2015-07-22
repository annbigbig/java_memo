package com.kashu.controller.login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"login_error_message","currentURL"})
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
		//model.addObject("currentURL", "/login");
		model.setViewName("login");
		System.out.println("LoginController.login() being called");
		return model;

	}
	
	//登入錯誤之後，Spring Security呼叫此函式
	@RequestMapping(value = "/login_err", method = {RequestMethod.GET,RequestMethod.POST})
	public String login_err(@ModelAttribute("currentURL") String currentURL, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		model.addAttribute("login_error_message", "登入錯誤:帳號或密碼不正確 (from session)");
		//response.addCookie(new Cookie("cookie_login_err_messages",URLEncoder.encode("login error : (from cookie)", "UTF-8")));
		System.out.println("currentURL=" + currentURL);
		//return "redirect:/user_only";
		return "redirect:"+currentURL;
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
	
}
