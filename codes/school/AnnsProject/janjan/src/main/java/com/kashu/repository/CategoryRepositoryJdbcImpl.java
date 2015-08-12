package com.kashu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kashu.domain.Category;

@Repository("categoryRepository")
public class CategoryRepositoryJdbcImpl implements CategoryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			return category;
		}
	} //end-of-class CategoryRowMapper

	@Override
	public List<Category> findAll() {
		String sql = "SELECT * FROM TB_CATEGORIES";
		List<Category> categories = jdbcTemplate.query(sql, new CategoryRowMapper());
		return categories;
	}

}
