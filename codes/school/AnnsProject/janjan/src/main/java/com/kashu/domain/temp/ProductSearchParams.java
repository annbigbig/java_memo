package com.kashu.domain.temp;

import java.util.HashMap;
import java.util.Map;

public class ProductSearchParams {
	private String searchColumn;
	private String searchOperator;
	//private Map<String,Object> searchArgValues = new HashMap<String,Object>();
	//private Map<String,Object> searchArgTypes = new HashMap<String,Object>();
	private Object[] searchArgValues = new Object[] {};
	private int[] searchArgTypes = new int[] {};		//must be filled with java.sql.Types
	private String orderColumn;
	private String orderType;
	private Integer pageNumber;
	private Integer pageSize;
	
	public String getSearchColumn() {
		return searchColumn;
	}
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}
	public String getSearchOperator() {
		return searchOperator;
	}
	public void setSearchOperator(String searchOperator) {
		this.searchOperator = searchOperator;
	}
	public Object[] getSearchArgValues() {
		return searchArgValues;
	}
	public void setSearchArgValues(Object[] searchArgValues) {
		this.searchArgValues = searchArgValues;
	}
	public int[] getSearchArgTypes() {
		return searchArgTypes;
	}
	public void setSearchArgTypes(int[] searchArgTypes) {
		this.searchArgTypes = searchArgTypes;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
