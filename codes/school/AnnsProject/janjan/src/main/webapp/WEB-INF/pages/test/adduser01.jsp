<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test/adduser01.jsp</title>
</head>
<body>
<h1>test/adduser01.jsp</h1><br/>
<c:if test="${not empty user}">
  user.username=${user.username}<br/>
  user.password=${user.password}<br/>
  user.email=${user.email}<br/>

  <br/><br/>
</c:if>
</body>
</html>