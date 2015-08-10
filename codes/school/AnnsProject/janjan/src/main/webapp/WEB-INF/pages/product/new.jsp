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
    <div id="container">
    <form:form id="addProductform" modelAttribute="product" method="post" action="${pageContext.request.contextPath}/admin/product/new">
        <div id="left">
    
    		<h2 class="contact">新增產品</h2>
    		
    		 <p></p>
    			<form:label path="title">產品標題</form:label><br/>
    			<form:input path="title" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入產品名稱" maxlength="14" /><br/>
    		 <p></p> 
    			
    		 <p></p>
    			<form:label path="price">價格</form:label><br/>
    			<form:input path="price" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入此產品的單價" maxlength="14"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="unit">確認密碼</form:label><br/>
    			<form:input path="unit" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入計價單位" maxlength="14"/><br/>
    		 <p></p>
    			
    			    <!-- 提交鈕 -->
    			<input name="submit" id="submit" value="新增產品" type="submit"/><br/><br/>
    			  <div id="errors-total"  class="error">
    		   <!-- jquery validation plugin 產生的驗證錯誤訊息放入這個div元素 (client端) -->
    		   <div id="errors-client"></div>
    			    
    		   <!-- hibernate validator 產生的驗證錯誤訊息放入這個div元素 (server端) -->
    		   <div id="errors-server">
    		      <form:errors path="title"/><br/>
    		      <form:errors path="price"/><br/>
    		      <form:errors path="unit"/><br/>
    		      <c:if test="${not empty db_error_messages}">
    		      					${db_error_messages}
    		      </c:if>
    		   </div>
    		 </div>
    </div>
    
    <div id="middle"></div>
    <div id="right">
    		 
    		 
    </div>
    </form:form>
		
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