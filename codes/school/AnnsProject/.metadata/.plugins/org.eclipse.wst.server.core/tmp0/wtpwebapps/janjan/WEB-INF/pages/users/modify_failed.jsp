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
		<h2>修改個人資料 - [ 錯誤頁面 ]</h2>
		<c:if test="${not empty error_message_no_login}">
		  ${error_message_no_login}<br/>
		</c:if>
		<c:if test="${not empty error_message_access_deny}">
		  ${error_message_access_deny}<br/>
		</c:if>
		<c:if test="${not empty error_message_not_exist}">
		  ${error_message_not_exist}<br/>
		</c:if>
		<c:if test="${not empty error_message_updated_failed}">
		  ${error_message_updated_failed}<br/>
		</c:if>
		
		   <br/><a href="${pageContext.request.contextPath}/home">回首頁</a><br/>
    </article>
    
    <nav>
          <jsp:include page="../login.jsp"/>
    </nav>
    
    <aside>aside<br>
    <h2></h2>
    
    <h2></h2>
    <c:import url="/part"/>
    </aside>
    
 </div>
 <footer>footer</footer>


</body>
</html>