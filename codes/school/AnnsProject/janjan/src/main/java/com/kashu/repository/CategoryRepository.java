package com.kashu.repository;

import java.util.List;
import com.kashu.domain.Category;

public interface CategoryRepository {
	public List<Category> findAll();
}
