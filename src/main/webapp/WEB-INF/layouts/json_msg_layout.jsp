<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<json:object>
	<json:property name="code" value="${code}"/>
	<json:property name="msg" value="${msg}"/>
</json:object>