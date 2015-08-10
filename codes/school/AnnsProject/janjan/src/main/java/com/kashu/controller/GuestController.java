package com.kashu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kashu.domain.Role;
import com.kashu.domain.User;
import com.kashu.service.UserService;
import com.kashu.validator.UserValidator;

@Controller
@RequestMapping("/register")
//@SessionAttributes(value = "user",types = User.class)
public class GuestController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//這兩行沒寫的話，不能把表單的生日轉成Date物件
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//設定User物件的校驗器
		binder.setValidator(userValidator);
	}

	//準備註冊用的User的空白模型
	@ModelAttribute("user")
	public User initModel(){
		User user = new User();
		Role r1 = new Role("ROLE_USER");
		user.addRole(r1);
		user.setEnabled(true);
		user.setErrorCounters(0);
		return user;
	}
	
	//給出空白的用戶註冊表單
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model){
		//model.addAttribute("user", new User());
		return "users/register";
	}
	
	//處理提交來的用戶注冊資訊
	@RequestMapping(method = RequestMethod.POST)
	public String register(@ModelAttribute @Valid User user,BindingResult result, Model model){
		String viewName = "users/register_success";
		//userValidator.validate(user, result);
		if(result.hasErrors()){
			viewName = "users/register";
			System.out.println("result.getFieldErrorCount()=" + result.getFieldErrorCount());
		}else{
			
			//設定新用戶的createdTime和lastModified欄位值
			Date now = new Date();
			user.setCreatedTime(now);
			user.setLastModified(now);
			
			//試著寫入user到資料庫
			if(userService.create(user)==null){
				model.addAttribute("db_error_messages", "註冊失敗，沒有寫入資料庫");
				viewName = "users/register";
			}else{
				model.addAttribute("user", user);
			}
			
		}
		return viewName;
	}

}
