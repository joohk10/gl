<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<div>
	<input type="hidden" name="roomSeq" id="roomSeq" value="${roomSeq }" />
	<input type="hidden" name="mySeq" id="mySeq" value="${mySeq }" />
	<h1>채팅방</h1>
	
	<div id="chatWrap">
		<ul id="chatLog"></ul>
		
		<div id="chatBox">
			<div id="chatInputBox">
				<textarea id="chatInput"></textarea>
			</div>
			<div id="chatSendBtn">
				<span>전송</span>
			</div>
		</div>
	</div>
</div>