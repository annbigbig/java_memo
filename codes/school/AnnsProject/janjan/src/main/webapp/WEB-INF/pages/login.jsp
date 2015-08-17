<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<h2>${title}</h2>
<h2>${msg}</h2>
  <!-- 已登入的一般會員會看到會員可發動的功能列表 -->
	<sec:authorize access="hasRole('ROLE_USER')">
  	<script>
			$(document).ready(function() { 
			    $('#logout_link').click(function(e) {
			        e.preventDefault();
			        $('#logoutForm').submit();
			    });
			    
			    $('#personal_mod_button').click(function(){
			        window.location='${pageContext.request.contextPath}/user/modify/<sec:authentication property="principal.username"/>';
			    });
			    
			});
  </script>
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				您好，<sec:authentication property="principal.username"/><br/>
				<a href="#" id="logout_link">登出</a> | <button type="button" id="personal_mod_button">修改個人資料</button>
			</h2>
		</c:if>
	</sec:authorize>
	
	<!-- 未登入的訪客會看到登入表單 -->
	<sec:authorize access="isAnonymous()">
	<script>
	$(document).ready(function() { 
   	$('#password_send_link').click(function(e){
 	     e.preventDefault();
 	     var username = $('#username').val();
      window.location='password_send?username='+username;
   		//alert("test");
       });
    });
	</script>
	<h3>會員登入</h3>

	<div id="login-box">

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<!-- 從Session裡面拿出error_message_in_session變數 -->
		<c:if test="${not empty login_err_flag_session}">
			<div class="error">登入失敗：帳號或密碼錯誤</div>
			<c:remove var="login_err_flag_session" scope="session"/>
		</c:if>
		
		<!-- 這是從cookie拿，不過想想算了，好難用 -->
		<c:if test="${not empty cookie.cookie_login_err_flag.value}">
		 <!-- <div class="error">登入錯誤:帳號或密碼不正確 (from cookie)</div> -->
		</c:if>
  
		<form name='loginForm'
			action="<c:url value='/auth/login_check'/>"
			method='POST'>

			<table>
				<tr>
					<td>帳號:<input type='text' name='username' id='username' maxlength="14" style="width: 140px;"></td>
				</tr>
				<tr>
					<td>密碼:<input type='password' name='password' maxlength="14" style="width: 140px;"/></td>
				</tr>

				<!-- if this is login for update, ignore remember me check -->
				
				<c:if test="${empty loginUpdate}">
					<tr>
						<td>Remember Me: <input type="checkbox" name="remember-me" /></td>
					</tr>
				</c:if>
				
				<tr>
					<td><input name="submit" type="submit" value="登入"/> | <input type="reset" value="清空"><br/>
					<a href="${pageContext.request.contextPath}/register" style="font-size: 16px;">註冊為新用戶</a> | <a href="#" id="password_send_link" style="font-size: 16px">找回密碼</a>
					</td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
	</sec:authorize>
	
	<!-- 管理員功能 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h2 class="pink-me">管理員功能</h2>
		<div class="admin-class">
		    <button type="button" id="user_new_button">新增會員</button> | 
		    <button type="button" id="user_find_button">查詢會員</button><br/>
		</div>

	</sec:authorize>
