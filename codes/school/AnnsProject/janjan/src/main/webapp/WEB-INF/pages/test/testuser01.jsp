<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test/testuser01.jsp</title>
</head>
<body>
test/testuser01.jsp<br/>
<c:if test="${not empty users}">
   <c:forEach items="${users}" var="user">
   			username=${user.username}<br/>
   			password=${user.password}<br/>
   			email=${user.email}<br/>
   </c:forEach>
</c:if>
</body>
</html>