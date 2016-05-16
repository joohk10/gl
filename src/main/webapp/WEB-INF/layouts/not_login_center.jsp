<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>

<div id="mainDiv">
	<img src="images/img_visual.png" />
	<div id="loginDiv">
		<form method="POST" action="loginAct.do">
		<input type="text" name="id" id="uId" />
		<input type="password" name="pw" id="uPw" />
		<input type="submit" id="loginSubmit" />
		</form>
	</div>
</div>

<div id="footer">
(주)CAT's-Eye 경기도 부천시천 원미구 지봉로 43<br>
대표자명: 조현규,김승목,심재훈,김지찬 이메일: CATEye@naver.co.kr
</div>