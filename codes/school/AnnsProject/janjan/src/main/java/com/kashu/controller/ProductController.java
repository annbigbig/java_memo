package com.kashu.controller;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kashu.domain.Category;
import com.kashu.domain.Product;
import com.kashu.property.editors.CategoryEditor;
import com.kashu.service.CategoryService;
import com.kashu.service.ProductService;
import com.kashu.utility.RandomUtil;
import com.kashu.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RandomUtil randomUtil;
	
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
	@ModelAttribute("product")
	public Product initModel(){
		Product product = new Product();
		product.setTitle("");
		product.setPrice(0);
		product.setUnit("個");
		return product;
	}
	
	//準備分類Categories的map物件
	@ModelAttribute("categoriesMap")
	public Map initCategories(){
		List<Category> categories = categoryService.findAll();
		Map categoriesMap = new HashMap<String,String>();
		for(Category c : categories){
			System.out.println(c.getId() + " : " + c.getName());
			categoriesMap.put(c.getId(), c.getName());
		}
		return categoriesMap;
	}
	
	@RequestMapping(value="/admin/product/new ",method=RequestMethod.GET)
	public String addForm(Model model){
		return "product/new";
	}
	
	@RequestMapping(value="/admin/product/new ",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute @Valid Product product,BindingResult result,Model model){
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
			if(p.getId()==null){
				model.addAttribute("error_message_db", "新增失敗，無法寫入產品到資料庫");
				viewName = "product/new";
			}else{
				//寫入成功
				model.addAttribute("product", p);
			}
		}
		
		System.out.println("addProduct() was called");
		return viewName;
	}
	
	@RequestMapping(value="/admin/product/modify/{id}",method=RequestMethod.GET)
	public String modify_form(@PathVariable Long id,Model model){
		System.out.println("id=" + id);
		model.addAttribute("id", id);
		return "product/modify";
	}
	
	//產生10筆隨機的產品資料，新增至資料庫
	@RequestMapping(value="/admin/product/random")
	public String random(Model model){
		
		List<Product> products = new ArrayList<Product>();
		Product p;
		//Category c;
		for(int i=0;i<10;i++){
			p = new Product();
			p.setTitle(randomUtil.get_a_chinese_word(randomUtil.get_a_number(6, 10)));
			p.setUnit(randomUtil.get_a_chinese_word(1));
			p.setPrice(randomUtil.get_a_number(100, 1000));
			p.setEnabled(false);
			switch(randomUtil.get_a_number(1, 3)){
				case 1:
					p.setCategory(new Category(1l,"jam"));
					break;
				case 2:
					p.setCategory(new Category(2l,"router"));
					break;
				case 3:
					p.setCategory(new Category(3l,"book"));
					break;
			}
			products.add(p);
		}
	
		Integer inserted_rows = productService.insert(products);
		model.addAttribute("inserted_rows", inserted_rows);
		model.addAttribute("products",products);
		
		return "product/random";
	}
	
	@RequestMapping(value="/admin/product/delete")
	public String delete(@RequestParam(value="id",required = false) Long id,Model model){
		if(productService.delete(id)){
			model.addAttribute("product_id", id);
			return "product/delete_success";
		}
		
		return "product/delete_failed";
	}
	/*
	@RequestMapping(value="/product/detail/{id}")
	public String detail(@PathVariable Long id){
		//Product product = productService.
		return "";
	}
	*/
	
}
