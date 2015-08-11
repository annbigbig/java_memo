package com.kashu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.domain.Category;
import com.kashu.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		List<Category> categories = null;
		try{
			categories = categoryRepository.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return categories;
	}

}
