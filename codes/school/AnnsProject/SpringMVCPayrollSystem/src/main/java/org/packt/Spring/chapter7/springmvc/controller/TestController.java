package org.packt.Spring.chapter7.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/test")
public class TestController {

	//匹配 http://www.domain.com/appcontext/test/delete?employeeId=3
	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("message","呼叫了add()");
		return "test";
	}
	
	//匹配 http://www.domain.com/appcontext/test/remove?employeeId=3
	//匹配 http://www.domain.com/appcontext/test/delete?employeeId=3
	@RequestMapping(value = {"/remove", "/delete"}, method = RequestMethod.GET)
	public String remove(@RequestParam("employeeId") int employeeId,Model model){
		model.addAttribute("message","呼叫了remove(),employeeID=" + employeeId);
		return "test";
	}
	
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String get(@PathVariable("employeeId") int employeeId,Model model){
		model.addAttribute("message","呼叫了get(),employeeId=" + employeeId);
		return "test";
	}
}
