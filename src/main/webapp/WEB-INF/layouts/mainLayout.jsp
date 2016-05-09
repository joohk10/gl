<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TITLE</title>
</head>
<body>
<div id="wrap">
	<div id="AllArea">
		<div id="Header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="Container">
			<div id="TopMenu">
				<tiles:insertAttribute name="topmenu" />
			</div>
			<div id="LeftMenu">
				<tiles:insertAttribute name="leftmenu" />
			</div>
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div id="Footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</div>
</body>
</html>