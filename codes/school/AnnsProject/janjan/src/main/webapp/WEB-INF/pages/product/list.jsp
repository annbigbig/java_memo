<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="../fragments/staticFiles.jsp"/>
<script>
$(function() {
	$("#navlist li").click(function(){
		var content = $(this).text();
		alert('content = ' + content);
	});
	
	$("#firstPageButton").click(function(){
		$("#pageNumber").val(1);
		$("#searchForm").submit();
	});
	
	$("#previous10PageButton").click(function(){
		var currentPage = $("#pageNumber").val();
		$("#pageNumber").val(+currentPage-10);
		$("#searchForm").submit();
	});
	
	$("#previousPageButton").click(function(){
		var currentPage = $("#pageNumber").val();
		$("#pageNumber").val(+currentPage-1);
		$("#searchForm").submit();
	});
	
	$("a.page").not("#firstPageButton,#previous10PageButton,#previousPageButton,#nextPageButton,#next10PageButton,#lastPageButton").click(function(){
		//alert($(this).text());
		$("#pageNumber").val($(this).text());
		$("#searchForm").submit();
	});
	
	$("#nextPageButton").click(function(){
		var currentPage = $("#pageNumber").val();
		$("#pageNumber").val(+currentPage+1);
		$("#searchForm").submit();
	});
	
	$("#next10PageButton").click(function(){
		var currentPage = $("#pageNumber").val();
		$("#pageNumber").val(+currentPage+10);
		$("#searchForm").submit();
	});
	
	$("#lastPageButton").click(function(){
		//var maxPageNumber = ${page.maxPageNumber};
		$("#pageNumber").val("<c:out value='${page.maxPageNumber}'/>");
		$("#searchForm").submit();
	});
	
	$("#pageNumberInput").mask("000");
	
	$("#goToButton").click(function(){
		var pageNumber = $("#pageNumberInput").val();
		if(pageNumber==null||pageNumber==0){
			pageNumber =1;
		}
		$("#pageNumber").val(pageNumber);
		$("#searchForm").submit();
	});
	
});
</script>
</head>
<body>

 <header>header</header>
 <div id='main'>
    <article>
   			
   			<c:if test="${not empty searchParams}">
   					<form id="searchForm" action="${pageContext.request.contextPath}/admin/product/find" method="post">
   								<input type="hidden" name="searchColumn" value="${searchParams.searchColumn}"/>
										<input type="hidden" name="searchOperator" value="${searchParams.searchOperator}"/>
										<input id="argValue0" type="hidden" name="searchArgValues[0]" value="${searchParams.searchArgValues[0]}"/>
										<input type="hidden" name="searchArgTypes[0]" value="${searchParams.searchArgTypes[0]}"/>
										<input type="hidden" name="orderColumn" value="${searchParams.orderColumn}"/>
										<input type="hidden" name="orderType" value="${searchParams.orderType}"/>
										<input id="pageNumber" type="hidden" name="pageNumber" value="${searchParams.pageNumber}"/>
										<input type="hidden" name="pageSize" value="${searchParams.pageSize}"/>
   					</form>
   			</c:if><br/>
   			
   			<c:if test="${not empty totalRows}">
   							totalRows = ${totalRows}<br/><br/>
   			</c:if>
   			
   			<br/><br/>
   			<c:choose>
   				<c:when test="${not empty page.elements}">
   				 <table>
   				 <thead>
   				 		<th>產品名稱</th>
   				 		<th>價格</th>
   				 		<th>單位</th>
   				 		<th></th>
   				 	</thead>
   				 	<tbody>
   						<c:forEach var="product" items="${page.elements}">
   									<tr>
   										<td><a href="${pageContext.request.contextPath}/admin/product/detail/${product.id}">${product.title}</a></td>
   										<td>${product.price}</td>
   										<td>${product.unit}</td>
   										<!-- product.createdTime = ${product.createdTime} -->
   										<!-- product.lastModified = ${product.lastModified} -->
												<!-- product.enabled = ${product.enabled} --> 
												<!-- product.category.id = ${product.category.id} --> 
												<!-- product.category.name = ${product.category.name} --> 
												<td><button type="button">修改</button>|<button type="button">刪除</button>
											</tr>
   						</c:forEach>
   					</tbody>
   					</table>
   				</c:when>
   				<c:otherwise>
   								要求的頁面不存在<br/><br/>
   				</c:otherwise>
   			</c:choose>
  
   			<a href="${pageContext.request.contextPath}/home">回首頁</a><br/>
   			
   			<c:if test="${not empty page.pageButtons}">
   						${page.pageButtons}<br/>
   			</c:if>
    </article>
   
    <nav>
          <jsp:include page="../login.jsp"/>
    </nav>
    
    <aside>aside<br>
    <h2></h2>
    <c:url var="part" value="/part"></c:url>
    <h2>${part}</h2>
    <c:import url="/part"/>
    </aside>
    
 </div>
 <footer>footer</footer>


</body>
</html>