<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<div id="wrap">
<link rel="stylesheet" type="text/css" href="css/index.css">
<img src=images/index.jpg usemap="#main">
	<map name="main">
		<area shape="rect" coords="145,123,200,145" href="./chatAct.do"/>
		<area shape="rect" coords="145,157,200,178" href="./listAct.do"/>
		<area shape="rect" name="logout" coords="947,22,1032,45" href="./logoutAct.do"/>
		<area shape="rect" coords="218,45,247,153" href="c"/>
		<area shape="rect" coords="103,233,154,283" href="d"/>
		<area shape="rect" coords="170,267,200,278" href="e"/>
	</map>
	<div>
	<form method="POST" action="tt.php" id="chatform">
	<ul>
	<li id="p1" >테스트</li>
	<input id="seq" name="seq" type="hidden" value="6" />
	<li id="p2" >200921327</li>
	<input id="num" name="num" type="hidden" value="200921327" />
	</ul>
	<input type="submit" value="submit">
	</div>
</form>
</div>
</body>
</html>