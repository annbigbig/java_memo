<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="../fragments/staticFiles.jsp"/>
<script>
$(function() {
	
	//initialize the datepicker for birthday field
    $("#datepicker").datepicker({
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
    
  });
</script>
</head>
<body>

 <header>header</header>
 <div id='main'>
    <article>
    <div id="container">
    <form id="regform"> 
    <div id="left">
    
    		<h2 class="contact">註冊為新用戶</h2>
    		
    		 <p></p>
    			<label for="username">帳號名稱</label>
    			<br/>
    			<input id="username" name="username" placeholder="請輸入要申請的帳號名稱" type="text" maxlength="14">
    		 <p></p> 
    			
    		 <p></p>
    			<label for="password">密碼</label>
    			<br/> 
    			<input id="password" name="password" placeholder="請輸入您設定的密碼" type="password" maxlength="14">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="cpassword">確認密碼</label>
    			<br/>
    			<input id="cpassword" name="cpassword" placeholder="請再次輸入您設定的密碼" type="password" maxlength="14">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="email">E-Mail</label>
    			<br/>
    			<input id="email" name="email" placeholder="your@e-mail.address" type="email" maxlength="30">
    		 <p></p>
    			
    			<input name="submit" id="submit" value="註冊為新用戶" type="submit"> 	 
    		
    </div>
    <div id="middle"></div>
    <div id="right">
    		 <p></p><br/><br/><br/>
    			<label for="nickname">暱稱</label>
    			<br/>
    			<input id="nickname" name="nickname" placeholder="請輸入您的暱稱" type="text" maxlength="14">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="realname">真實姓名</label>
    			<br/>
    			<input id="realname" name="realname" placeholder="請輸入您的真實姓名" type="text" maxlength="20">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="gender">性別</label>
    			<br/>
    			<input type="radio" name="gender" value="1" checked>男
    			<input type="radio" name="gender" value="0">女
    		 <p></p>
    		 
    		 <p></p>
    			<label for="birthday">生日</label>
    			<br/>
    			<input type="text" id="datepicker" name="birthday">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="telephone">市內電話</label>
    			<br/>
    			<input id="telephone" name="telephone" placeholder="(00)0000-0000" type="text">
    		 <p></p>
    		 
    		 <p></p>
    			<label for="mobile">行動電話</label>
    			<br/>
    			<input id="mobile" name="mobile" placeholder="0000-000-000" type="text">
    		 <p></p>
    		 
    		 <p></p>
    		 <label for="zipcode">郵遞區號</label>
    		 <br/>
    		 <div id="twzipcode"></div>
    		 <p></p>
    		 
    		 <p></p>
    			<label for="address">收件地址</label>
    			<br/>
    			<input id="address" name="address" placeholder="請輸入您的收件地址" type="text" maxlength="70">
    		 <p></p>
    		 
    </div>
    </form> 
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