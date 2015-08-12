package com.kashu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.domain.Product;
import com.kashu.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insert(Product product) {
		Product p = null;
		try{
		  p = productRepository.insert(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Product update(Product product) {
		
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		Boolean b = false;
		try{
			b = productRepository.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = null;
		try{
			products = productRepository.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> find(Map<String, Object> searchParams) {
		List<Product> products = null;
		try{
			products = productRepository.find(searchParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}
	
}
