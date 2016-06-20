<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div id="worldCupDiv">

	<div id="worldCupWrapDiv">
	<h1>8강</h1>
<c:choose>
	<c:when test="${fn:length(memberList) == 8}">
	<ul class="pList">
		<c:forEach var="item" items="${memberList}">
		<li class="r16s notView" seq="${item.seq}">
			<span class="hobby">${item.hobby }</span>
			<span class="intro">${item.intro }</span>
			<span class="image"><img src="http://img.naver.net/static/www/u/2013/0731/nmms_224940510.gif" /></span>
		</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
	인원수가 부족합니다.
	</c:otherwise>
</c:choose>

	</div>
	
</div>