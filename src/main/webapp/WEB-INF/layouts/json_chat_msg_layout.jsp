<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<json:object>
	<json:property name="type" value="${type}"/>
	<json:property name="msgCnt" value="${fn:length(chatLog) }" />
	<json:array name="msgList" var="item" items="${chatLog }">
		<json:object>
			<json:property name="memName" value="${item.memName }"/>
			<json:property name="chatLogSeq" value="${item.chatLogSeq }"/>
			<json:property name="chatMsg" value="${item.chatMsg }"/>
			<json:property name="chatTime" value="${item.chatTime }"/>
			<json:property name="chatMemSeq" value="${item.chatMemSeq }" />
		</json:object>
	</json:array>
</json:object>