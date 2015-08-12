package com.kashu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kashu.domain.Category;
import com.kashu.domain.Product;
import com.kashu.exception.InsertFailedException;
import com.kashu.exception.DeleteFailedException;

@Repository("productRepository")
public class ProductRepositoryJdbcImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setTitle(rs.getString("title"));
			product.setPrice(rs.getInt("price"));
			product.setUnit(rs.getString("unit"));
			product.setCreatedTime(rs.getDate("createdTime"));
			product.setLastModified(rs.getDate("lastModified"));
			product.setEnabled(rs.getBoolean("enabled"));
				Category category = new Category();
				category.setId(rs.getLong("category_id"));
				category.setName(rs.getString("category_name"));
			product.setCategory(category);
			return product;
		}
	} //end-of-class ProductRowMapper
	
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

	@Override
	public List<Product> findAll() {
		List<Product> products = null;
		String sql = "SELECT t.id,t.title,t.price,t.unit,"
				+ "t.createdTime,t.lastModified,t.enabled,"
				+ "t.category_id,c.name as category_name "
				+ "FROM TB_PRODUCTS as t LEFT JOIN TB_CATEGORIES as c "
				+ "ON t.category_id = c.id ORDER BY t.id ASC";
		products = jdbcTemplate.query(sql, new ProductRowMapper());
		System.out.println("findAll() : " + products.size());
		return products;
	}

	@Override
	public List<Product> find(Map<String, Object> searchParams) {
		List<Product> products = null;
		//String sql = "SELECT * FROM TB_PRODUCTS" + getWhere(searchParams);
		String sql = "SELECT t.id,t.title,t.price,t.unit,"
				+ "t.createdTime,t.lastModified,t.enabled,"
				+ "t.category_id,c.name as category_name "
				+ "FROM TB_PRODUCTS as t LEFT JOIN TB_CATEGORIES as c "
				+ "ON t.category_id = c.id" + getWhere(searchParams);
		
		System.out.println("sql = " + sql);
		Object[] argValues = (Object[])searchParams.get("argValues");
		System.out.println("======= argValues =======");
		for(Object o: argValues){
			System.out.println("o.toString() = " + o.toString());
		}
		int[] argTypes = (int[])searchParams.get("argTypes");
		System.out.println("======= argTypes =======");
		for(int i : argTypes){
			System.out.println("i.toString() = " + i);
		}
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(sql,argTypes);
		products = jdbcTemplate.query(psCreatorFactory.newPreparedStatementCreator(argValues),new ProductRowMapper());
		return products;
	}

	@Override
	public List<Product> find(Map<String, Object> searchParams,
			Map<String, Object> orderParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> find(Map<String, Object> searchParams,
			Map<String, Object> orderParams, Map<String, Object> pageParams) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getWhere(Map<String,Object> searchParams){
		String where = "";
		String column = searchParams.get("column").toString();
		String operator = searchParams.get("operator").toString();
		Object[] argValues = (Object[])searchParams.get("argValues");
		if((column!= null)&&(operator!=null)&&(argValues!=null)){
			where = " WHERE " + column;
			switch(operator){
			 case "LIKE":
				 where += " LIKE ?";
				 break;
			 case "BETWEEN":
				 where += " BETWEEN ? AND ?";
				 break;
			 default:
				 where += " " + operator + "?"; 
				 break;
			}
		}
		System.out.println("where = " + where);
		return where;
	}
	
	public String getOrder(Map<String,Object> orderParams){
		String order = "";
		String column = orderParams.get("column").toString();
		String type = orderParams.get("type").toString();
		if((column!=null)&&(type!=null)){
			if(type.equals("ASC")){
				order = " ORDER BY " + column + " ASC";
			}else if(type.equals("DESC")){
				order = " ORDER BY " + column + " DESC";
			}
		}
		System.out.println("order = " + order);
		return order;
	}
	
	public String getLimit(Map<String,Object> pageParams){
		String limit = "";
		
		return limit;
	}

}
