<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script>
	$(document).ready(function() { 		
		$("#searchButton").click(function(e) {
			//e.preventDefault();
			//var productTitle = $('#productTitle').val();
			//$('#productTitle').val('%' + productTitle + '%');
			  $( "#searchFormLeft" ).submit();
			});
	});
	</script>
		<div class="guest-class">
		  	<form id="searchFormLeft" method="GET" action="${pageContext.request.contextPath}/product/find">
				<input type="hidden" name="searchColumn" value="title"/>
				<input type="hidden" name="searchOperator" value="LIKE"/>
				<input id="productTitle" type="text" name="searchArgValues[0]" maxlength="8" size="3"/>
				<input type="hidden" name="searchArgTypes[0]" value="12"/>
				<input type="hidden" name="orderColumn" value="id"/>
				<input type="hidden" name="orderType" value="ASC"/>
				<input type="hidden" name="pageNumber" value="1"/>
				<input type="hidden" name="pageSize" value="10"/>
			</form><button type="button" id="searchButton">查詢產品</button> <br/>
			
				<!-- 管理員功能 -->
				<sec:authorize access="hasRole('ROLE_ADMIN')">
						<script>
						$(document).ready(function() {
								$('#product_new_button').click(function(e){
					      		window.location='${pageContext.request.contextPath}/admin/product/new';
					      		});
						
								$('#random_insert_button').click(function(e){
					      		window.location='${pageContext.request.contextPath}/admin/product/random';
						 		 });
						});
						</script>
						<button type="button" id="product_new_button">新增產品</button> |
						<button type="button" id="random_insert_button">隨機新增10筆產品資料</button>
				</sec:authorize>
		</div>
