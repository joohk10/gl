<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div>
<form method="POST" action="regChatRoom.do">
<input type="text" name="inviteSeq">
<input type="submit">
</form>
<c:choose>
	<c:when test="${fn:length(chatRoomList) > 0}">
	aaaaa
	</c:when>
	<c:otherwise>
	생성된 채팅방이 없습니다.
	</c:otherwise>
</c:choose>

</div>