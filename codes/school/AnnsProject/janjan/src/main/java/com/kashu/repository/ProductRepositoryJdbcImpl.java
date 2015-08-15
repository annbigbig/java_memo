package com.kashu.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kashu.domain.Category;
import com.kashu.domain.Product;
import com.kashu.domain.temp.ProductSearchParams;
import com.kashu.exception.InsertFailedException;
import com.kashu.exception.DeleteFailedException;

@Repository("productRepository")
public class ProductRepositoryJdbcImpl implements ProductRepository {
	private String sql_base = "SELECT p.id,p.title,p.price,p.unit,"
			+ "p.createdTime,p.lastModified,p.enabled,"
			+ "p.category_id,c.name as category_name "
			+ "FROM TB_PRODUCTS as p LEFT JOIN TB_CATEGORIES as c "
			+ "ON p.category_id = c.id";
	
	private String sql_count_rows = "SELECT COUNT(p.id) FROM TB_PRODUCTS AS p";
	private String sql_insert_a_row = "INSERT INTO TB_PRODUCTS(title,price,unit,enabled,category_id) VALUES(?,?,?,?,?)";
	
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
		String sql = sql_base + " ORDER BY p.id ASC";
		products = jdbcTemplate.query(sql, new ProductRowMapper());
		System.out.println("findAll() : " + products.size());
		return products;
	}

	@Override
	public List<Product> find(ProductSearchParams searchParams) {
		List<Product> products = null;
		String sql = getSqlForQuery(searchParams);
		int[] searchArgTypes = searchParams.getSearchArgTypes();
		Object[] searchArgValues = searchParams.getSearchArgValues();
		System.out.println("//-----debug----ProductRepository.find()----//");
		for(Object value : searchArgValues){
			System.out.println("value=" + value);
		}
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(sql,searchArgTypes);
		products = jdbcTemplate.query(psCreatorFactory.newPreparedStatementCreator(searchArgValues),new ProductRowMapper());
		return products;
	}
	
	public String getSqlForQuery(ProductSearchParams searchParams){
		String sql = sql_base + getWhere(searchParams) + getOrder(searchParams) + getLimit(searchParams);
		System.out.println("//----debug----//");
		System.out.print("sql = " + sql);
		return sql;
	}
	
	public String getWhere(ProductSearchParams searchParams){
		String where = "";
		String searchColumn = searchParams.getSearchColumn();
		String searchOperator = searchParams.getSearchOperator();
	
		if(searchColumn!=null && searchOperator!=null){
			switch(searchOperator){
					case "LIKE":
						where = " WHERE p." + searchColumn + " LIKE ?";  
						break;
					case "BETWEEN":
						where = " WHERE p." + searchColumn + " BETWEEN ? AND ?";
						break;
					default:
						where = " WHERE p." + searchColumn + " " + searchOperator + " ?";
						break;
			}
		}
		System.out.println("//----debug----//");
		System.out.print("where = " + where);
		return where;
	}
	
	public String getOrder(ProductSearchParams searchParams){
		String order = "";
		String orderColumn = searchParams.getOrderColumn();
		String orderType = searchParams.getOrderType();
		if(orderColumn!=null && orderType!=null){
			if(orderType.equals("ASC")){
				order = " ORDER BY p." + orderColumn + " ASC";
			}else if(orderType.equals("DESC")){
				order = " ORDER BY p." + orderColumn + " DESC";
			}
		}
		System.out.println("//----debug----//");
		System.out.print("order = " + order);
		return order;
	}
	
	public String getLimit(ProductSearchParams searchParams){
		String limit = "";
		Integer pageNumber = searchParams.getPageNumber();
		Integer pageSize = searchParams.getPageSize();
		if(pageNumber<1) pageNumber = 1;
		if((pageSize>10)||(pageSize<1)) pageSize = 10;
		limit = " LIMIT " + (pageNumber-1)* pageSize + "," + pageSize;
		
		System.out.println("//----debug----//");
		System.out.print("limit = " + limit);
		return limit;
	}

	@Override
	public Long countAll() {
		
		return null;
	}

	@Override
	public Long count(ProductSearchParams searchParams) {
		Long rowCount = 0l;
		String sql = sql_count_rows + getWhere(searchParams);
		int[] searchArgTypes = searchParams.getSearchArgTypes();
		Object[] searchArgValues = searchParams.getSearchArgValues();
		System.out.println("");
		System.out.println("//-----ProductRepository.count()-----//");
		for(Object value : searchArgValues){
			System.out.println("value=" + value);
		}
		rowCount = jdbcTemplate.queryForLong(sql, searchArgValues, searchArgTypes);
		return rowCount;
	}

	@Override
	public Integer insert(List<Product> products) {
		int[] counts = jdbcTemplate.batchUpdate(sql_insert_a_row, new BatchPreparedStatementSetter(){
			@Override
			public int getBatchSize() {
				return products.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Product product = products.get(i);
				ps.setString(1, product.getTitle());
				ps.setInt(2, product.getPrice());
				ps.setString(3, product.getUnit());
				ps.setBoolean(4, product.getEnabled());
				ps.setLong(5, product.getCategory().getId());
			}
		});
		return counts.length;
	}
	
}
