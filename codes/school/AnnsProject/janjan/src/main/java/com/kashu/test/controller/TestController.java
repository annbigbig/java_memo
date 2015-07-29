package com.kashu.test.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.kashu.test.domain.Member;
import com.kashu.test.validator.MemberValidator;

@Controller
@RequestMapping("/test01")
@SessionAttributes("member")
public class TestController {

	@Autowired
	private MemberValidator memberValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//這兩行沒寫的話，不能把表單的生日轉成Date物件
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//設定Member物件的校驗器
		binder.setValidator(memberValidator);
		binder.setDisallowedFields("membername","testint","testdouble");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String formB(Model model){
		model.addAttribute("member", new Member());
		return "test/testform01";
	}
	
	/*
	public ModelAndView formA(){
		return new ModelAndView("test/testform01","member",new Member());
	}
	*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processB(@Valid @ModelAttribute Member member, BindingResult result){
		ModelAndView mv = new ModelAndView("test/testresult01");
		if(result.hasErrors()){
			mv.setViewName("test/testform01");
			System.out.println("result.getFieldErrorCount()=" + result.getFieldErrorCount());
		}
		return mv;
	}
	
	/*
  public String processA(@ModelAttribute Member member){	
		return "test/testresult01";
	}
	*/
	
}
