package com.kashu.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.kashu.domain.Role;
import com.kashu.domain.User;
import com.kashu.service.UserService;
import com.kashu.validator.UserValidator;

@Controller
@RequestMapping("/user")
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
	@RequestMapping(value="/modify/{username}",method=RequestMethod.GET)
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
	
	@RequestMapping(value="/modify" , method = RequestMethod.POST)
	public String modify(@Valid @ModelAttribute User user, BindingResult result, Model model){
		String viewName = "users/modify_success";
		if(result.hasErrors()){
			viewName = "users/modify_form";
		}else{
			//以用戶提交來的User資料，取出id欄位值之後，再拿它叫EntityManager取出User物件u
			User u = userService.findById(user.getId());
			
			if(u==null){
				model.addAttribute("error_message_not_exist", "該用戶不存在");
				viewName = "users/modify_failed";
			}else{
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
				

			//寫入user修改時間
			u.setLastModified(new Date());
			
			
			/*
			Role r = new Role();
			r.setROLE("ROLE_USER");
			r.setUsername(user.getUsername());
			user.getRoles().add(r);
			*/
				
				//更新物件u
				if(userService.update(u)==null){
					model.addAttribute("error_message_updated_failed", "沒有寫入用戶資料到資料庫，更新失敗");
					viewName = "users/modify_failed";
				}else{
					model.addAttribute("user", u);
				}
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
	
	//just for test delete feature
	@RequestMapping("/delete")
	public String deleteOne(@RequestParam(value="id",required = false) Long id,Model model){
		User u = userService.findById(id);
		if(u==null){
			model.addAttribute("message", "該用戶不存在");
		}else{
			// try to delete that one
			System.out.println("u.id=" + u.getId());
			if(userService.delete(u)==null){
				model.addAttribute("message", "用戶" + u.getUsername()+"刪除失敗");
			}else{
				model.addAttribute("message", "用戶" + u.getUsername()+"刪除成功");
			}
		}
		
		return "users/deleteResult";
	}
	
	//just for test list users feature
	@RequestMapping("/list")
	public String list(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users/listall";
	}
	
}
