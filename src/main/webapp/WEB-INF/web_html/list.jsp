<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div>
   <c:choose>
	<c:when test="${fn:length(greencount) > 0}">
	<ul class="pList">
		<c:forEach var="item" items="${greencount}">
		<li>
		<h3>
			<span class="w">
			나에게 그린라이트를 보낸 사람의 수는 ${item.cnt}명입니다.<br><br>
			</span>
		</h3>
		</li>
		</c:forEach>
		</ul>
		</b>
	</c:when>
	</c:choose>
	<c:choose>
	<c:when test="${fn:length(greenlist) > 0}">
	<b><h1>
	사진 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	이름 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
	 학번 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 상태</h1>
	<ul class="pList">
		<c:forEach var="item" items="${greenlist}">
		<li>
		<h3>
			<span class="w">
			<img src="./${item.filen }" width=100px, height=100px />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
			${item.name} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			${item.num} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div style="position: relative; left: 420px; top: -50px;">
			<table width="60" height="50" background="images/cat2.jpg">
			<tr>
			<td style="padding-top:11px; padding-right:25px;">
			<img src="images/green.jpg">
			</td>
			</tr>
			</table>
			</div>
			</span>
		</h3>
		</li>
		</c:forEach>
	</ul>
	</b>
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose>
</div>