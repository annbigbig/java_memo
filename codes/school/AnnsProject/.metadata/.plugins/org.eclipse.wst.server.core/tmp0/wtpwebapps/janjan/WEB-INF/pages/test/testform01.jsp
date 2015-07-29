<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testform01</title>
</head>
<body>

<form:form id="testform" modelAttribute="member" method="post" action="test01">
       <p/><p/>
       <form:label path="membername">帳號名稱</form:label><br/>
    			<form:input path="membername" placeholder="請輸入會員名稱" maxlength="14" /><br/>
    			<form:errors path="membername"/><br/>
    			
    			<p/><p/>
    		 <form:label path="password">密碼</form:label><br/>
    			<form:input path="password" placeholder="請輸入密碼" maxlength="14" /><br/>
    			<form:errors path="password"/><br/>
    			
    			<p/><p/>
    			<form:label path="cpassword">確認密碼</form:label><br/>
    			<form:input path="cpassword" maxlength="14" /><br/>
    			<form:errors path="cpassword"/><br/>
    			
    			<p></p>
    			<form:label path="email">E-Mail</form:label><br/>
    			<form:input path="email" placeholder="your@e-mail.com" maxlength="30" /><br/>
    			<form:errors path="email"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="birthday">生日</form:label><br/>
    			<form:input path="birthday" placeholder="生日格式(yyyy-MM-dd)" maxlength="10" /><br/>
    			<form:errors path="birthday"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    		 <form:label path="testint">測試整數</form:label><br/>
    		 <form:input path="testint"/><br/>
    		 <form:errors path="testint"/>
    		 <p></p>
    		 
    		 <p></p>
    		 <form:label path="testdouble">測試浮點數</form:label><br/>
    		 <form:input path="testdouble"/><br/>
    		 <form:errors path="testdouble"/>
    		 <p></p>
    			
    			<p/><p/>
    			<input name="submit" id="submit" value="提交" type="submit"/><br/>
    			
</form:form>

</body>
</html>