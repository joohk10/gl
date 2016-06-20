<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>

<div>
	<form method="POST" action="SearchResult.do" id="searchform">
	<select name="sel">
    <option value="">검색항목</option>
    <option value="name">이름</option>
    <option value="num">학번</option>
	</select>
	<input type="text" name="search" id="search" />
	<input type="submit" value="검색">
	</form>
	<c:choose>
	<c:when test="${fn:length(searchlist) > 0}">
	<ul class="pList">
		<c:forEach var="item" items="${searchlist}">
		<li>
			<span class="w">${item.name } 님과의 대화</span>
		</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
	생성된 채팅방이 없습니다.
	</c:otherwise>
</c:choose>
</div>