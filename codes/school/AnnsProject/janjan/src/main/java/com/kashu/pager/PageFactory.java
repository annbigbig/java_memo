package com.kashu.pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;
import com.kashu.service.ProductService;

@Component
public class PageFactory {
	
	@Autowired
	private static ProductService productService;

	public static Page<Product> getPage(ProductSearchParams searchParams){
		
		return null;
	}
	
	public static Boolean isThisPageExisted(ProductSearchParams searchParams){
		return null;
	}
	
	public static Long totalRows(ProductSearchParams searchParams){
		Long result = 0l;
		result = productService.count(searchParams);
		return result;
	}
	
}
