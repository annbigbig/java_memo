<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test/getuser01.jsp</title>
</head>
<body>
<h1>test/getuser01.jsp</h1><br/>
<c:if test="${not empty user}">
     			username=${user.username}<br/>
   			password=${user.password}<br/>
   			email=${user.email}<br/>
   			nickname=${user.nickname}<br/>
   			realname=${user.realname}<br/>
   			gender=${user.gender}<br/>
   			birthday=${user.birthday}<br/>
   			telephone=${user.telephone}<br/>
   			mobile=${user.mobile}<br/>
   			zipcode=${user.zipcode}<br/>
   			address=${user.address}<br/>
   			createdTime=${user.createdTime}<br/>
   			lastModified=${user.lastModified}<br/>
   			errorCounters=${user.errorCounters}<br/>
   			enabled=${user.enabled}<br/>
					<c:forEach var="role" items="${user.roles}">   		
   						ROLE=${role.ROLE}<br/>
   			</c:forEach>
   			<br/><br/>

  <br/><br/>
</c:if>
</body>
</html>