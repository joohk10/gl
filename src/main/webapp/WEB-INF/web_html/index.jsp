<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>

hello <c:out value="${uName}"></c:out>
<a href="./logoutAct.do">로그아웃</a>