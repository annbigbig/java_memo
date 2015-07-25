<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>果醬男孩 v0.2</title>

    <spring:url value="/resources/css/layout.css" var="layoutCss"/>
    <link href="${layoutCss}" rel="stylesheet"/>
    
    <spring:url value="/resources/jquery/ui/1.11.4/jquery-ui.css" var="jQueriUiCss"/>
    <spring:url value="/resources/jquery/ui/1.10.4/jquery-ui-1.10.4.custom.min.css" var="jQueriUiCss_old"/>
    <link href="${jQueriUiCss}" rel="stylesheet"/>
    
    <spring:url value="/resources/jquery/jquery-1.11.3.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    
    <spring:url value="/resources/jquery/ui/1.11.4/jquery-ui.min.js" var="jQueryUI"/>
    <spring:url value="/resources/jquery/ui/1.10.4/jquery-ui-1.10.4.custom.min.js" var="jQueryUI_old"/>
    <script src="${jQueryUI}"></script>

    <spring:url value="/resources/jquery/twzipcode/jquery.twzipcode.min.js" var="jQueryTwzipcode"/>
    <script src="${jQueryTwzipcode}"></script>
    
    <spring:url value="/resources/jquery/mask/jquery.mask.min.js" var="jQueryMask"/>
    <script src="${jQueryMask}"></script>
    
    <spring:url value="/resources/jquery/validation/1.14.0/jquery.validate.min.js" var="jQueryValidate"/>
    <script src="${jQueryValidate}"></script>
    
    <spring:url value="/resources/jquery/validation/1.14.0/additional-methods.min.js" var="addtionalMethod"/>
    <script src="${addtionalMethod}"></script>
    