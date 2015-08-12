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
   			<h1>查詢產品列表</h1><br/>
   			提交了column = ${column} <br/>
   			operator = ${operator} <br/>
   			argValue = ${argValue} <br/>
   			<br/>
   			
   			<c:if test="${not empty products}">
   						<c:forEach var="product" items="${products}">
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