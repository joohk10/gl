<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<%String saveDir = request.getSession().getServletContext().getRealPath("/");%>
<div>
	<form method="POST" action="SearchResult.do" id="searchform">
	<select name="sel">
    <option value="1">이름</option>
    <option value="2">학번</option>
	</select>
	<input type="text" name="search" id="search" />
	<input type="submit" value="검색">
	</form>
	<c:choose>
	<c:when test="${fn:length(searchlist) > 0}">
	사진 이름 학번 선택
	<ul class="pList">
		<c:forEach var="item" items="${searchlist}">
		<li>
			<span class="w">
			<img src="saveDir+${item.filen}">
			${item.name} ${item.num}
			<img src="images/cat2.jpg">
			</span>
		</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>