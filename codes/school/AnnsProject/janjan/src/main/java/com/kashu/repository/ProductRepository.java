package com.kashu.repository;

import java.util.List;
import java.util.Map;

import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;

public interface ProductRepository {
	public Product insert(Product product);
	public Integer insert(List<Product> products);
	public Product update(Product product);
	public Boolean delete(Long id);
	public Product find(Long id);
	public List<Product> find(ProductSearchParams searchParams);
	public List<Product> findAll();
	public Long countAll();
	public Long count(ProductSearchParams searchParams);
	/*
	public List<Product> find(Map<String,Object> searchParams);
	public List<Product> find(Map<String,Object> searchParams, Map<String,Object> orderParams);
	public List<Product> find(Map<String,Object> searchParams, Map<String,Object> orderParams, Map<String,Object> pageParams);
	*/
	/*
	public List<Product> update(List<Product> products);
	public Boolean isExisted(Long id);
	public Long countAll();
	public Long count(Map<String,Object> searchParams);
	*/
	
}
