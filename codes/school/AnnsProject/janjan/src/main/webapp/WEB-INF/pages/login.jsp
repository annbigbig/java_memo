<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<h2>${title}</h2>
<h2>${msg}</h2>
  <!-- 已登入的一般會員會看到會員可發動的功能列表 -->
	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			$(document).ready(function() { 
			    $('#logout_link').click(function(e) {
			        e.preventDefault();
			        $('#logoutForm').submit();
			    });
			    
			    $('#personal_mod_button').click(function(){
			        window.location='user/mod?username='
			    });
			});
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				您好，<sec:authentication property="principal.username"/><br/>
				<a href="#" id="logout_link">登出</a> | <button type="button" id="personal_mod_button">修改個人資料</button>
			</h2>
		</c:if>
	</sec:authorize>
	
	<!-- 未登入的訪客會看到登入表單 -->
	<sec:authorize access="isAnonymous()">
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
					<td>帳號:<input type='text' name='username'></td>
				</tr>
				<tr>
					<td>密碼:<input type='password' name='password' /></td>
				</tr>

				<!-- if this is login for update, ignore remember me check -->
				
				<c:if test="${empty loginUpdate}">
					<tr>
						<td>Remember Me: <input type="checkbox" name="remember-me" /></td>
					</tr>
				</c:if>
				
				<tr>
					<td><input name="submit" type="submit" value="submit"/></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h1>you are ROLE_ADMIN</h1>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<h1>you are ROLE_USER</h1>
	</sec:authorize>
	
	<sec:authorize access="isRememberMe()">
		<h2># This user is login by "Remember Me Cookies".</h2>
	</sec:authorize>
	
	
	<sec:authorize access="isFullyAuthenticated()">
		<h2># This user is login by username / password.</h2>
	</sec:authorize>
