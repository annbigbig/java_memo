<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>果醬男孩 v0.2</title>

    <spring:url value="/resources/css/layout.css" var="layoutCss"/>
    <link href="${layoutCss}" rel="stylesheet"/>
    
    <spring:url value="/resources/jquery/ui/1.11.4/jquery-ui.css" var="jQueriUiCss"/>
    <link href="${jQueriUiCss}" rel="stylesheet"/>
    
    <spring:url value="/resources/jquery/jquery-1.11.3.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    
    <spring:url value="/resources/jquery/ui/1.11.4/jquery-ui.min.js" var="jQueryUI"/>
    <script src="${jQueryUI}"></script>

    