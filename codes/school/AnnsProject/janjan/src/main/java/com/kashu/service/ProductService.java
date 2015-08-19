package com.kashu.service;

import java.util.List;
import java.util.Map;

import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;
import com.kashu.pager.Page;

public interface ProductService {
	public Product insert(Product product);
	public Integer insert(List<Product> products);
	public Product update(Product product);
	public Boolean delete(Long id);
	public Boolean isThisPageExisted(ProductSearchParams searchParams);
	//public List<Product> findAll();
	//public List<Product> find(ProductSearchParams searchParams);
	public Page<Product> getPage(ProductSearchParams searchParams);
	//public Long countAll();
	public Long count(ProductSearchParams searchParams);
	public Product find(Long id);

	/*
	public List<Product> update(List<Product> products);
	public Boolean isExisted(Long id);
	public List<Product> find(Map<String,Object> searchParams, Map<String,Object> orderParams);
	public List<Product> find(Map<String,Object> searchParams, Map<String,Object> orderParams, Map<String,Object> pageParams);
	public Long countAll();
	public Long count(Map<String,Object> searchParams);
	*/
}
