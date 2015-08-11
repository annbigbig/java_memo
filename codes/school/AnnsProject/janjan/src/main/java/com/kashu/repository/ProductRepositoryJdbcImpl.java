package com.kashu.repository;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

import com.kashu.domain.Product;

public class ProductRepositoryJdbcImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product insert(Product product) {
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"insert into account(owner_name,balance,access_time,locked) values(?,?,?,?)",
				new int[] { Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP,
						Types.BOOLEAN });
		return null;
	}

	@Override
	public Product update(Product product) {
		
		return null;
	}

}
