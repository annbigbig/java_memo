package com.kashu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kashu.domain.Product;
import com.kashu.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductValidator productValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//這兩行沒寫的話，不能把表單的生日轉成Date物件
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//設定Product物件的校驗器
		binder.setValidator(productValidator);
	}
	
	//準備註冊用的Product的空白模型
	@ModelAttribute
	public Product initModel(){
		Product product = new Product();
		product.setPrice(0);
		product.setUnit("個");
		return product;
	}
	
	@RequestMapping(value="/admin/product/new ",method=RequestMethod.GET)
	public String addForm(){
		return "product/new";
	}
	
}