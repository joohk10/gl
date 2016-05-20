<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<img src=images/index.jpg usemap="#main">
<map name="main">
		<area shape="rect" coords="145,123,200,145" href="#"/>
		<area shape="rect" coords="145,157,200,178" href="#"/>
		<area shape="rect" name="logout" coords="947,22,1032,45" href="./logoutAct.do"/>
		<area shape="rect" coords="218,45,247,153" href="#"/>
		<area shape="rect" coords="103,233,154,283" href="#"/>
		<area shape="rect" coords="170,267,200,278" href="#"/>
	</map>
<div id="center">	
</html>
</div>
hello <c:out value="${uName}"></c:out>
<a href="./logoutAct.do">로그아웃</a>
</body>
</html>