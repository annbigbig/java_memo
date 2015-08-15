package com.kashu.pager;

import java.util.List;

import com.kashu.domain.temp.ProductSearchParams;

public class Page<T> {
	private List<T> elements;
	private ProductSearchParams searchParams;
	private String pageButtons;
	private Long totalRows;	//how many rows will be returned if we omit the LIMIT part in SQL query;
	private Integer maxPageNumber;
	
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
	
	// http://css.maxdesign.com.au/listamatic/horizontal13.htm
	// http://cssdeck.com/labs/css-pagination-styles
	public String initPageButtons(){
		String buttons = "<div id=\"pagebuttons-container\">\n";
		buttons += "<div class=\"pagination\">";
		
		Integer currentPageNumber = searchParams.getPageNumber();
		Integer pageSize = searchParams.getPageSize();
		Integer maxPageNumber = (totalRows.intValue() % pageSize ==0 ) ? (totalRows.intValue() / pageSize) : ((totalRows.intValue() / pageSize)+1);
		
		// first page
		if(currentPageNumber==1){
			buttons += "<span class=\"page active\">first</span>";
		}else{
			buttons += "<a id=\"firstPageButton\" href=\"#\" class=\"page\">first</a>";
		}
		
		// previous page
		if(currentPageNumber>1){
			buttons += "<a id=\"previousPageButton\" href=\"#\" class=\"page\">previous</a>";
		}
		
		
		// next page
		if(currentPageNumber<maxPageNumber){
			buttons += "<a id=\"nextPageButton\" href=\"#\" class=\"page\">next</a>";
		}
		
		//last page
		if(currentPageNumber==maxPageNumber){
			buttons += "<span class=\"page active\">last</span>";
		}else{
			buttons += "<a id=\"lastPageButton\" href=\"#\" class=\"page\">last</a>";
		}
		
		//enclose the </div>\n</div>
		buttons += "</div>\n</div>";
		
		return buttons;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getMaxPageNumber() {
		if(maxPageNumber==null){
			Integer totalRowsI = totalRows.intValue();
			Integer pageSize = searchParams.getPageSize();
			maxPageNumber = (totalRowsI % pageSize == 0) ? (totalRowsI / pageSize) : (totalRowsI / pageSize) + 1;
		}
		return maxPageNumber;
	}

	public void setMaxPageNumber(Integer maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}
	
}
