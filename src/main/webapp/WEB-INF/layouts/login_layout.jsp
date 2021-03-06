<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<c:if test="${fn:length(customCss) > 0}">
	<c:forEach var="item" items="${customCss}">
<link rel="stylesheet" type="text/css" href="${item }" />
	</c:forEach>
</c:if>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<c:if test="${fn:length(customJs) > 0}">
	<c:forEach var="item" items="${customJs}">
<script type="text/javascript" src="${item }"></script>
	</c:forEach>
</c:if>
<title>TITLE</title>
</head>
<body>
<div id="wrap">
<img src=images/index.jpg usemap="#main">
	<map name="main">
		<area shape="rect" coords="130,98,200,118" href="./search.do"/>
		<area shape="rect" coords="150,118,210,148" href="./chatRoomList.do"/>
		<area shape="rect" coords="145,157,200,178" href="./list.do"/>
		<area shape="rect" coords="95,187,220,210" href="./worldCup.do"/>
		<area shape="rect" name="logout" coords="947,22,1032,45" href="./logoutAct.do"/>
		<area shape="rect" coords="103,233,154,283" href="./editMember.do"/>
		<area shape="rect" coords="170,267,200,278" href="./editMember.do"/>
	</map>
	
	<tiles:insertAttribute name="body"/>
</div>

</body>
</html>
