package org.packt.Spring.chapter7.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Test2Controller {
	
	@RequestMapping(value = "/foo", method = RequestMethod.GET)
	public String getEmployeeName(@RequestParam("employeeId") int employeeId,Model model){
		model.addAttribute("message", "getEmployeeName() , employeeId="+employeeId);
		return "bar";
	}

	@RequestMapping("/foo/add")
	public String addEmployee(Model model){
		model.addAttribute("message", "addEmployee()");
		return "bar";
	}
	
	@RequestMapping(value = {"/foo/remove","/foo/delete"}, method = RequestMethod.GET)
	public String removeEmployee(@RequestParam(value = "employeeId" , required = false) int employeeId,Model model){
		model.addAttribute("message", "removeEmployee() , employeeId="+employeeId);
		return "bar";
	}
}
