package com.kashu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.kashu.domain.Category;
import com.kashu.domain.Product;
import com.kashu.property.editors.CategoryEditor;
import com.kashu.repository.CategoryRepository;
import com.kashu.repository.ProductRepository;
import com.kashu.service.ProductService;
import com.kashu.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//這兩行沒寫的話，不能把表單的生日轉成Date物件
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//註冊自定義的CategoryEditor
		binder.registerCustomEditor(Category.class,new CategoryEditor());
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
	public String addForm(Model model){
		List<Category> categories = categoryRepository.findAll();
		
		Map categoriesMap = new HashMap<String,String>();
		for(Category c : categories){
			System.out.println(c.getId() + " : " + c.getName());
			categoriesMap.put(c.getId(), c.getName());
		}
		
		model.addAttribute("categories", categories);
		model.addAttribute("categoriesMap", categoriesMap);
		return "product/new";
	}
	
	@RequestMapping(value="/admin/product/new ",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute @Valid Product product,Model model,BindingResult result){
		String viewName = "product/new_success";
		if(result.hasErrors()){
			viewName = "product/new";
		}else{
			//試著將Product寫入資料庫
			System.out.println("product.title=" + product.getTitle());
			System.out.println("product.price=" + product.getPrice());
			System.out.println("product.enabled=" + product.getEnabled());
			System.out.println("product.unit=" + product.getUnit());
			System.out.println("product.category.id=" + product.getCategory().getId());
			Product p = productService.insert(product);
			//if(p.getId()==null){
				//model.addAttribute("error_message_db", "新增失敗，無法寫入產品到資料庫");
				//viewName = "product/new";
			//}else{
				//寫入成功
				model.addAttribute("product", p);
			//}
		}
		
		System.out.println("addProduct() was called");
		return viewName;
	}
	
}
