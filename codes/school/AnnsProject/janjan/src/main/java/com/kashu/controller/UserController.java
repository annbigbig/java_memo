package com.kashu.controller;

import java.security.Principal;
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
		String viewName = "users/modify_failed";
		String logonUsername = getLoginUsername(principal);
		if(logonUsername.equals("") || logonUsername.length()==0){
			model.addAttribute("error_message_no_login", "訪客不得使用此功能");
		}else if(!username.equals(getLoginUsername(principal))){
			model.addAttribute("error_message_access_deny", "你不是該用戶，禁止修改該用戶資料");
		}else{
			//試著取出該用戶資料
			User user = userService.findByUsername(username);
			if(user==null){
				model.addAttribute("error_message_not_exist", "該用戶不存在");
			}else{
				model.addAttribute("user",user);
				viewName = "users/modify_form";
			}
		}
		
		return viewName;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String modify(@Valid @ModelAttribute User user, Model model, BindingResult result){
		String viewName = "users/modify_success";
		if(result.hasErrors()){
			viewName = "users/modify_form";
		}else{
			//以用戶提交來的User資料，取出username欄位值之後，再拿它叫EntityManager取出User物件u
			User u = userService.findByUsername(user.getUsername());
			//System.out.println("hashcode of u = " + u.hashCode());
			//System.out.println("hashcode of user = " + user.hashCode());
			
			//if(u==null){
			//	model.addAttribute("error_message_not_exist", "該用戶不存在");
			//	viewName = "users/modify_failed";
			//}else{
				//將用戶的修正放入u這個物件實體
				
				u.setPassword(user.getPassword());
				u.setNickname(user.getNickname());
				u.setRealname(user.getRealname());
				u.setGender(user.getGender());
				u.setBirthday(user.getBirthday());
				u.setTelephone(user.getTelephone());
				u.setMobile(user.getMobile());
				u.setZipcode(user.getZipcode());
				u.setAddress(user.getAddress());
				u.setLastModified(new Date());
				
				
				//更新物件u
				if(userService.update(u)==null){
				//if(userService.refresh(u)==null){
					model.addAttribute("error_message_updated_failed", "沒有寫入用戶資料到資料庫，更新失敗");
					viewName = "users/modify_failed";
				}else{
					model.addAttribute("user", u);
				}
			//}
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
