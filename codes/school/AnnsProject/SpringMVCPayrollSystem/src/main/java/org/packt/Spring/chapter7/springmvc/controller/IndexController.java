package org.packt.Spring.chapter7.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index.action")
public class IndexController {
	@RequestMapping(method = RequestMethod.GET)
	public String welcomeEmployee(ModelMap model) {
   	model.addAttribute("name", "Hello World!哈囉世界");
	   model.addAttribute("greetings","Welcome to 小安安的 - Spring MVC!!!");
	   return "index";
	}

}
