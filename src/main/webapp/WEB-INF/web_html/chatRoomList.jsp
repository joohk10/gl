<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div>
<!-- form method="POST" action="regChatRoom.do">
<input type="text" name="inviteSeq">
<input type="submit">
</form -->
<c:choose>
	<c:when test="${fn:length(chatRoomList) > 0}">
	<ul class="pList">
		<c:forEach var="item" items="${chatRoomList}">
		<li>
			<span class="w">${item.memName } 님과의 대화</span>
			<span class="b"><a href="chatRoom.do?seq=${item.chatRoomSeq }">입장</a></span>
		</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
	생성된 채팅방이 없습니다.
	</c:otherwise>
</c:choose>

</div>