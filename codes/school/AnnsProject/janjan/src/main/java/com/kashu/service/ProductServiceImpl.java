package com.kashu.service;

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

}