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

@Repository("productRepository")
public class ProductRepositoryJdbcImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product insert(Product product) {
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"INSERT INTO TB_PRODUCTS(title,price,unit,enabled,category_id) VALUES(?,?,?,?,?)",
				new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.BOOLEAN, Types.BIGINT });
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int count = jdbcTemplate.update(
				psCreatorFactory.newPreparedStatementCreator(
						new Object[] {product.getTitle(),product.getPrice(),product.getUnit(),product.getEnabled(),product.getCategory().getId()})
						,keyHolder);
		if (count != 1){
			throw new InsertFailedException("Cannot insert Product");
		}
		product.setId(keyHolder.getKey().longValue());
		return product;
	}

	@Override
	public Product update(Product product) {
		
		return null;
	}

}
