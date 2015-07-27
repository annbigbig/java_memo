package com.kashu.controller.login;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kashu.domain.User;
import com.kashu.domain.validator.UserValidator;


@Controller
@SessionAttributes({"login_err_flag_session","currentURL"})
public class LoginController {
	
	@Autowired
	private UserValidator userValidator;

	//沒有使用的函式
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		System.out.println("LoginController.login() being called");
		return model;
	}
	
	//給出空白的註冊表單
	@RequestMapping(value="/register",method = RequestMethod.GET)
	//public String register_form(Model model){
	public String register_form(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "users/register";
	}
	
	//處理提交來的用戶注冊資訊
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String register(@Valid User user,BindingResult result){
		String viewName = "users/register_success";
		userValidator.validate(user, result);
		if(result.hasErrors()){
			viewName = "users/register";
		}else{
			//試著寫入user到資料庫
		}
		return viewName;
	}
	
	//登入錯誤之後，Spring Security呼叫此函式 (使用session存放)
	@RequestMapping(value = "/login_err", method = {RequestMethod.GET,RequestMethod.POST})
	public String login_err(@ModelAttribute("currentURL") String currentURL, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		model.addAttribute("login_err_flag_session", "1");
		//response.addCookie(new Cookie("cookie_login_err_messages",URLEncoder.encode("login error : (from cookie)", "UTF-8")));
		System.out.println("currentURL=" + currentURL);
		//return "redirect:/user_only";
		return "redirect:"+currentURL;
	}
	
	//登入錯誤之後，Spring Security呼叫此函式 (使用cookie存放)
	@RequestMapping(value = "/login_err_cookie", method = {RequestMethod.GET,RequestMethod.POST})
	public String login_error_cookie(
			@CookieValue(value = "cookie_currentURL", defaultValue = "/home") String cookie_currentURL,
			HttpServletResponse response)
	{
		response.addCookie(new Cookie("cookie_login_err_flag","1"));
		System.out.println("cookie_currentURL=" + cookie_currentURL);
		return "redirect:"+cookie_currentURL;
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
