package com.kashu.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kashu.domain.User;
import com.kashu.service.UserService;
import com.kashu.validator.UserValidator;

@Controller
@RequestMapping("/user/modify")
public class UserController {

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
	
	//給出修改用戶的表單
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String form(@PathVariable String username, Principal principal, Model model){
		String viewName = "users/modify_form";
		if(!username.equals(getLoginUsername(principal))){
			model.addAttribute("error_message_access_deny", "你不是該用戶，禁止修改該用戶資料");
			viewName = "users/modify_failed";
		}else{
			//試著取出該用戶資料
			User user = userService.findByUsername(username);
			if(user==null){
				model.addAttribute("error_message_not_exist", "該用戶不存在");
				viewName = "users/modify_failed";
			}else{
				model.addAttribute("user",user);
			}
		}
		
		return viewName;
	}
	
	
	//返回現在登入的username
	private String getLoginUsername(Principal principal){
		String username = "";
		try{
		  username = principal.getName();
		}catch(Exception e){
			e.printStackTrace();
		}
		return username;
	}
	
}
