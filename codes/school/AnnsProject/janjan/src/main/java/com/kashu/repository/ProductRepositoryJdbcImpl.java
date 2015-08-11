package com.kashu.repository;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kashu.domain.Product;
import com.kashu.exception.InsertFailedException;
import com.kashu.exception.DeleteFailedException;

@Repository("productRepository")
public class ProductRepositoryJdbcImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product insert(Product product) {
		Product result = null;
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"INSERT INTO TB_PRODUCTS(title,price,unit,enabled,category_id) VALUES(?,?,?,?,?)",
				new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.BOOLEAN, Types.BIGINT });
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int count = jdbcTemplate.update(
				psCreatorFactory.newPreparedStatementCreator(
						new Object[] {product.getTitle(),product.getPrice(),product.getUnit(),product.getEnabled(),product.getCategory().getId()})
						,keyHolder);
		if (count == 1){
			product.setId(keyHolder.getKey().longValue());
			result = product;
		}
		return result;
	}

	@Override
	public Product update(Product product) {
		
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		Boolean result = false;
		int count = jdbcTemplate.update("DELETE FROM TB_PRODUCTS where id = ?",id);
		if (count == 1){
			result = true;
		}
		return result;
	}

}