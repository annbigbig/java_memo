package com.kashu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;
import com.kashu.pager.Page;
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
	public Integer insert(List<Product> products) {
		Integer insert_rows_count = 0;
		try{
			insert_rows_count = productRepository.insert(products);
		}catch(Exception e){
			e.printStackTrace();
		}
		return insert_rows_count;
	}
	
	@Override
	public Product update(Product product) {
		Product p = null;
		try{
			p = productRepository.update(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
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

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@Override
	public Long count(ProductSearchParams searchParams) {
		Long result = 0l;
		try{
			result = productRepository.count(searchParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean isThisPageExisted(ProductSearchParams searchParams) {
		Integer totalRows = count(searchParams).intValue();
		Integer pageNumber = searchParams.getPageNumber();		// user requested page number
		Integer pageSize = searchParams.getPageSize();
		Integer maxPageNumber = (totalRows % pageSize == 0) ? (totalRows / pageSize) : ((totalRows / pageSize) + 1);
		return ((pageNumber > 0)&&(pageNumber <= maxPageNumber)) ? true : false;
	}

	@Override
	public Page<Product> getPage(ProductSearchParams searchParams) {
		Page<Product> page = new Page<Product>(searchParams);
		List<Product> products = null;
		Long totalRows = 0l;
		try{
			products = productRepository.find(searchParams);
			totalRows = productRepository.count(searchParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		page.setElements(products);
		page.setTotalRows(totalRows);
		return page;
	}

	@Override
	public Product find(Long id) {
		Product product = null;
		try{
			product = productRepository.find(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}
	
}
