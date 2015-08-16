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
		buttons += "<div class=\"pagination\">\n";
		
		Integer currentPageNumber = searchParams.getPageNumber();
		Integer pageSize = searchParams.getPageSize();
		Integer maxPageNumber = (totalRows.intValue() % pageSize ==0 ) ? (totalRows.intValue() / pageSize) : ((totalRows.intValue() / pageSize)+1);
		
		// first page
		if(currentPageNumber==1){
			buttons += "<span class=\"page active\">|&lt;</span>\n";
		}else{
			buttons += "<a id=\"firstPageButton\" href=\"#\" class=\"page\">|&lt;</a>\n";
		}
		
		// previous 10 page
		if(currentPageNumber>10){
			buttons += "<a id=\"previous10PageButton\" href=\"#\" class=\"page\">&lt;&lt;</a>\n";
		}
		
		// previous page
		if(currentPageNumber>1){
			buttons += "<a id=\"previousPageButton\" href=\"#\" class=\"page\">&lt;</a>\n";
		}
		
		// number part
		int min = (currentPageNumber % pageSize != 0) ? (((currentPageNumber / 10) * 10) + 1) : (((currentPageNumber / 10)- 1) * 10) +1;
		for(int i=min;i<min+10;i++){
			if(i<=maxPageNumber){
				if(i==currentPageNumber){
					buttons += "<span class=\"page active\">" + i + "</span>\n";
				}else{
					buttons += "<a href=\"#\" class=\"page\">"  + i + "</a>\n";
				}
			}
		}
		
		// next page
		if(currentPageNumber<maxPageNumber){
			buttons += "<a id=\"nextPageButton\" href=\"#\" class=\"page\">&gt;</a>\n";
		}
		
		// next 10 page
		if(currentPageNumber+10<=maxPageNumber){
			buttons += "<a id=\"next10PageButton\" href=\"#\" class=\"page\">&gt;&gt;</a>\n";
		}
		
		//last page
		if(currentPageNumber==maxPageNumber){
			buttons += "<span class=\"page active\">&gt;|</span>\n";
		}else{
			buttons += "<a id=\"lastPageButton\" href=\"#\" class=\"page\">&gt;|</a>\n";
		}
		
		//go this page
		buttons += "<input id=\"pageNumberInput\" type=\"text\" maxlength=\"3\" size=\"2\"/>\n";
		buttons += "<label>(" + currentPageNumber + "/" + maxPageNumber + ")</label>";
		buttons += "<button id=\"goToButton\" type=\"button\">Go</button>\n";
		
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
