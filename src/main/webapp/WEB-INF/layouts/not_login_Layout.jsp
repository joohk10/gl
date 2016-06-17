<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/not_login.css">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<title>TITLE</title>
</head>
<body>

<div id="wrap">
	<div id="leftDiv">
		<tiles:insertAttribute name="left" />
	</div>
	<div id="centerDiv">
		<tiles:insertAttribute name="center" />
	</div>
	<div id="rightDiv">
		<tiles:insertAttribute name="right" />
	</div>
</div>

</body>
</html>