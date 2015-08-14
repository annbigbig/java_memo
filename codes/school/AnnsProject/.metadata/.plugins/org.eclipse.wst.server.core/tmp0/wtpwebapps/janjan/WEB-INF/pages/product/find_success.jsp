<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="../fragments/staticFiles.jsp"/>
<script>

</script>
</head>
<body>

 <header>header</header>
 <div id='main'>
    <article>
   			
   			<c:if test="${not empty searchParams}">
   						searchParams.searchColumn = ${searchParams.searchColumn}<br/>
   						searchParams.searchOperator = ${searchParams.searchOperator}<br/>
   						searchParams.searchArgValues[0] = ${searchParams.searchArgValues[0]}<br/>
   						searchParams.searchArgTypes[0] = ${searchParams.searchArgTypes[0]}<br/>
   						searchParams.orderColumn = ${searchParams.orderColumn}<br/>
   						searchParams.orderType = ${searchParams.orderType}<br/>
   						searchParams.pageNumber = ${searchParams.pageNumber}<br/>
   						searchParams.pageSize = ${searchParams.pageSize}<br/>
   			</c:if><br/>
   			
   			<c:if test="${not empty totalRows}">
   							totalRows = ${totalRows}<br/><br/>
   			</c:if>
   			
   			<br/><br/>
   			<c:if test="${not empty page.elements}">
   						<c:forEach var="product" items="${page.elements}">
   									product.id = ${product.id} <br/>
											product.title = ${product.title} <br/>
											product.price = ${product.price} <br/>
											product.unit = ${product.unit} <br/>
											product.createdTime = ${product.createdTime}<br/>
											product.lastModified = ${product.lastModified} <br/>
											product.enabled = ${product.enabled} <br/>
											product.category.id = ${product.category.id} <br/>
											product.category.name = ${product.category.name} <br/>
											<br/><br/>
   						</c:forEach>
   			</c:if>
   			
   			<a href="${pageContext.request.contextPath}/home">回首頁</a><br/>
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