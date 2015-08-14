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
	
	@RequestMapping(value="/admin/product/find")
	public String find(@ModelAttribute ProductSearchParams searchParams,Model model){
		model.addAttribute("searchParams", searchParams);
		//Long totalRows = PageFactory.totalRows(searchParams);
		//Long totalRows = productService.count(searchParams);
		//model.addAttribute("totalRows", totalRows);
		Boolean isThisPageExisted = productService.isThisPageExisted(searchParams);
		System.out.println("isThisPageExisted = " + isThisPageExisted);
		if(isThisPageExisted){
			model.addAttribute("page", productService.getPage(searchParams));
		}else{
			model.addAttribute("page", null);
		}
		//model.addAttribute("products",productService.find(searchParams));
		System.out.println("//-----debug-----//");
		//System.out.println("searchParams.getSearchArgValues().get('0')=" + searchParams.getSearchArgValues().get("0"));
		//System.out.println("searchParams.getSearchArgTypes().get('0')=" + searchParams.getSearchArgTypes().get("0"));
		/*
		System.out.println("searchParams.getSearchArgValues()[0]=" + searchParams.getSearchArgValues()[0]);
		System.out.println("searchParams.getSearchArgTypes()[0]=" + searchParams.getSearchArgTypes()[0]);
		System.out.println("searchParams.getOrderColumn()=" + searchParams.getOrderColumn());
		System.out.println("searchParams.getOrderType()=" + searchParams.getOrderType());
		System.out.println("searchParams.getPageNumber()=" + searchParams.getPageNumber());
		System.out.println("searchParams.getPageSize()=" + searchParams.getPageSize());
		*/

		return "product/find_success";
	}

	
}
