package com.kashu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;
import com.kashu.pager.PageFactory;
import com.kashu.service.ProductService;

@Controller
public class ProductFindController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PageFactory pageFactory;
	
	@RequestMapping(value="/product/find")
	public String find(@ModelAttribute ProductSearchParams searchParams,Model model){
		model.addAttribute("searchParams", searchParams);
		
		Boolean isThisPageExisted = productService.isThisPageExisted(searchParams);
		System.out.println("isThisPageExisted = " + isThisPageExisted);
		if(isThisPageExisted){
			model.addAttribute("page", productService.getPage(searchParams));
		}else{
			model.addAttribute("page", null);
		}
		
		return "product/list";
	}
	
}
