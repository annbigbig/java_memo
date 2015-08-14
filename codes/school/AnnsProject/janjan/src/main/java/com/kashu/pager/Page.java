package com.kashu.pager;

import java.util.List;

import com.kashu.domain.temp.ProductSearchParams;

public class Page<T> {
	private List<T> elements;
	private ProductSearchParams searchParams;
	private String pageButtons;
	private Long totalRows;	//how many rows will be returned if we omit the LIMIT part in SQL query;
	
	public Page(ProductSearchParams searchParams){
		this.searchParams = searchParams;
	}

	public Page() {
		
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public ProductSearchParams getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(ProductSearchParams searchParams) {
		this.searchParams = searchParams;
	}

	public String getPageButtons() {
		if(pageButtons==null){
			pageButtons = initPageButtons();
		}
		return pageButtons;
	}

	public void setPageButtons(String pageButtons) {
		this.pageButtons = pageButtons;
	}
	
	public String initPageButtons(){
		String buttons = "<div id=\"navcontainer\">\n";
		buttons += "<ul id=\"navlist\">\n";
		
		Integer currentPageNumber = searchParams.getPageNumber();
		Integer pageSize = searchParams.getPageSize();
		Integer maxPageNumber = (totalRows.intValue() % pageSize ==0 ) ? (totalRows.intValue() / pageSize) : ((totalRows.intValue() / pageSize)+1);
		
		// first page
		if(currentPageNumber==1){
			buttons += "<li id=\"active\"><a href=\"#\" id=\"current\">第一頁</a></li>";
		}else{
			buttons += "<li><a href=\"#\">第一頁</a></li>";
		}
		
		// previous page
		
		
		//last page
		if(currentPageNumber==maxPageNumber){
			buttons += "<li id=\"active\"><a href=\"#\" id=\"current\">最後頁</a></li>";
		}else{
			buttons += "<li><a href=\"#\">最後頁</a></li>";
		}
		
		
		//enclose the </ul></div>
		buttons += "</ul>\n</div>";
		
		return buttons;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}
	
}
