<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="../fragments/staticFiles.jsp"/>
<script>
$(function() {
	
	//initialize the datepicker for birthday field
    $("#birthday").datepicker({
    	changeYear: true,
    	changeMonth: true,
    	minDate: "-100y",
    	maxDate: "-18y",
    	yearRange: "c-20:c+20",
    	dateFormat: "yy-mm-dd",
    }).datepicker('setDate',new Date()).attr('readonly',true);
    
    //initialize the zipcode selector
    $("#twzipcode").twzipcode({
    	  language: 'lang/zh-tw',
    	  readonly: true,
    	  onDistrictSelect: function(){
    		    var data = $("input[name*='zipcode']").val();
    		    //$("#zipcode").val(data);
    		    console.log(data);
    	         }
    	   });
    
    //this is for jquery-mask-plugin
    $("#telephone").mask("(00)0000-0000");
    $("#mobile").mask("0000-000-000");
   
    $("#regform").validate({
    	    rules:{
    	    	        username: {
    	    	        	    required: true,
    	    	        	    minlength: 4,
    	    	        	    maxlength: 14
    	    	                              },
    	    	        password: {
    	    	        	    required: true,
    	    	        	    minlength: 6,
    	    	        	    maxlength: 14
    	    	                             },
    	    	        cpassword: {
    	    	        	    required: true,
    	    	        	    minlength: 6,
    	    	        	    maxlength: 14,
    	    	        	    equalTo: "#password"
    	    	                             },
    	    	        email: {
    	    	        	    required: true,
    	    	        	    email: true
    	    	                             }
    	              },
    	    messages:{
    	    	        username: {
    	                 required: "帳號名稱不得為空",
    	                 minlength: "帳號的長度至少需6個字元",
    	                 maxlength: "帳號的長度最多是14個字元"
    	    	                             },
    	    	        password: {
    	    	        	   required: "密碼不得為空",
    	    	        	   minlength: "密碼的長度至少需6個字元",
    	    	        	   maxlength: "密碼的長度最多是14個字元"
    	    	                             }
    	              },
    	    highlight:function(element){
    	    	     $(element).addClass('error-by-jquery-validation');
    	               },
    	    unhighlight:function(element){
    	         $(element).removeClass('error-by-jquery-validation');
    	               },
    	    errorElement: "div",
    	    errorClass: "error-message-jquery-validate",
    	    errorPlacement: function(error, element){
    	    	     error.appendTo("div#errors-client");
    	              }
    	      });
 
  });
</script>
</head>
<body>

 <header>header</header>
 <div id='main'>
    <article>
    <div id="container">
    <form:form id="regform" modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/modify">
    <div id="left">
    
    		<h2 class="contact">修改個人資料</h2>
    		
    		 <p></p>
    			<form:label path="username">帳號名稱</form:label><br/>
    			<form:input path="username" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入要申請的帳號名稱" maxlength="14" /><br/>
    		 <p></p> 
    			
    		 <p></p>
    			<form:label path="password">密碼</form:label><br/>
    			<form:input path="password" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入您設定的密碼" maxlength="14" type="password"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="cpassword">確認密碼</form:label><br/>
    			<form:input path="cpassword" cssErrorClass="error-by-hibernate-validation" placeholder="請再次輸入您設定的密碼" maxlength="14" type="password"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="email">E-Mail</form:label><br/>
    			<form:input path="email" cssErrorClass="error-by-hibernate-validation" placeholder="your@e-mail.com" maxlength="30" /><br/>
    		 <p></p>
    		 
    		        <!-- 不要忘了加入這個hidden元素，Spring Security需要它，否則提交表單時會報錯 -->
    			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    			
    			    <!-- 提交鈕 -->
    			<input name="submit" id="submit" value="註冊為新用戶" type="submit"/><br/><br/>
    			  <div id="errors-total"  class="error">
    		   <!-- jquery validation plugin 產生的驗證錯誤訊息放入這個div元素 (client端) -->
    		   <div id="errors-client"></div>
    			    
    		   <!-- hibernate validator 產生的驗證錯誤訊息放入這個div元素 (server端) -->
    		   <div id="errors-server">
    		      <form:errors path="username"/><br/>
    		      <form:errors path="password"/><br/>
    		      <form:errors path="cpassword"/><br/>
    		      <form:errors path="email"/>
    		      <c:if test="${not empty db_error_messages}">
    		      					${db_error_messages}
    		      </c:if>
    		   </div>
    		 </div>
    </div>
    
    <div id="middle"></div>
    <div id="right">
    		 <p></p><br/><br/><br/>
    			<p></p>
    			<form:label path="nickname">暱稱</form:label><br/>
    			<form:input path="nickname" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入您的暱稱" maxlength="20" /><br/>
    			<form:errors path="nickname"/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="realname">真實姓名</form:label><br/>
    			<form:input path="realname" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入您的真實姓名" maxlength="20" /><br/>
    			<form:errors path="realname"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="gender">性別</form:label><br/>
    			<form:radiobutton path="gender" value="MALE" checked="checked"/>男
    			<form:radiobutton path="gender" value="FEMALE"/>女
    			<form:errors path="gender"/><br/>
    		 <p></p>
    		 
    		 <p></p>
    		 <form:label path="birthday">生日</form:label><br/>
    		 <form:input path="birthday"/><br/>
    		 <form:errors path="birthday"/>
    			<!-- <input type="text" id="datepicker" name="birthday"> -->
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="telephone">市內電話</form:label><br/>
    			<form:input path="telephone" placeholder="(00)0000-0000"/><br/>
    			<form:errors path="telephone"/>
    		 <p></p>
    		 
    		 <p></p>
    			<form:label path="mobile">行動電話</form:label><br/>
    			<form:input path="mobile" placeholder="0000-000-000"/><br/>
    			<form:errors path="mobile"/>
    		 <p></p>
    		 
    		 <p></p>
    		 <form:label path="zipcode">郵遞區號</form:label><br/>
    		 <div id="twzipcode"></div>
    		 <form:errors path="zipcode"/>
    		 <p></p>
    		 
    		 <p></p>
    		 <form:label path="address">收件地址</form:label><br/>
    		 <form:input path="address" cssErrorClass="error-by-hibernate-validation" placeholder="請輸入您的收件地址" maxlength="70" /><br/>
    		 <form:errors path="address"/>
    		 <p></p>
    		 
    		 <p></p>
    		 <c:forEach items="${user.roles}" var="role">
    		 ${role.ROLE}<br/>
    		 </c:forEach>
    		 
    </div>
    <!-- </form>  -->
         </form:form> 
    </div>
		
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