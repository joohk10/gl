<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div id="worldCupDiv">

<c:choose>
	<c:when test="${fn:length(memberList) == 8}">
	<ul class="pList">
		<c:forEach var="item" items="${memberList}">
		<li>
			<span class="w">${item.seq }</span>
			<span class="b">${item.name }</span>
		</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
	인원수가 부족합니다.
	</c:otherwise>
</c:choose>

</div>