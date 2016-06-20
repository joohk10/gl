<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/join.css">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
 
<script>
function insertAct(){    
    var f = document.form;        
    if(!!f.name.value && !!f.num.value && !!f.id.value && !!f.pw.value && !!f.hobby.value&& !!f.intro.value) 
    {
        f.action = "register.do";
        f.submit();            
    }
    else 
    {
        alert("빈 항목이 있습니다.");
    }
}

$.fn.setPreview = function(opt){
    "use strict"
    var defaultOpt = {
        inputFile: $(this),
        img: null,
        w: 200,
        h: 200
    };
    $.extend(defaultOpt, opt);
 
    var previewImage = function(){
        if (!defaultOpt.inputFile || !defaultOpt.img) return;
 
        var inputFile = defaultOpt.inputFile.get(0);
        var img       = defaultOpt.img.get(0);
 
        // FileReader
        if (window.FileReader) {
            // image 파일만
            if (!inputFile.files[0].type.match(/image\//)) return;
 
            // preview
            try {
                var reader = new FileReader();
                reader.onload = function(e){
                    img.src = e.target.result;
                    img.style.width  = defaultOpt.w+'px';
                    img.style.height = defaultOpt.h+'px';
                    img.style.
                    img.style.display = '';
                }
                reader.readAsDataURL(inputFile.files[0]);
            } catch (e) {
                // exception...
            }
        // img.filters (MSIE)
        } else if (img.filters) {
            inputFile.select();
            inputFile.blur();
            var imgSrc = document.selection.createRange().text;
 
            img.style.width  = defaultOpt.w+'px';
            img.style.height = defaultOpt.h+'px';
            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";            
            img.style.display = '';
        // no support
        } else {
            // Safari5, ...
        }
    };
 
    // onchange
    $(this).change(function(){
        previewImage();
    });
};
 
 
$(document).ready(function(){
    var opt = {
        img: $('#img_preview'),
        w: 115,
        h: 115
    };
 
    $('#inputfile').setPreview(opt);
});
</script>
</head>
 
 
<body>
<div id="wrap">
<div id="joinDiv">
	<form name="form" method="POST" action="" id="joinform" enctype="multipart/form-data">
	
	<div id="profilePreview">
		<img src="images/profile.jpg" id="img_preview"><br>
		<b>사진</b><input type="file" value="프로필 사진" name="filen" id="inputfile"/>
	</div>
	<br>
	<b>성별</b>
	<input type="radio" name="sex" value=0 checked>남자
	<input type="radio" name="sex" value=1>여자<br><br>
	<b>이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="name" id="uName" /><br>
	학번&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="num" id="uNum" /><br>
	아이디&nbsp;&nbsp;&nbsp;
	<input type="text" name="id" id="uId" /><br>
	비밀번호
	<input type="password" name="pw" id="uPw" /><br>
	<b>취미&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="hobby" id="uHobby" /><br>
	자기소개</b><br>
	<textarea rows="5" cols="10" name="introd" id="intro"></textarea><br>
	<input type="submit" value="가입" id="joinSubmit" onclick="insertAct()"/>
	</form>
</div>
<div id="footer">
<b>
(주)CAT's-Eye 경기도 부천시 원미구 지봉로 43<br>
대표자명: 조현규,김승목,심재훈,김지찬 이메일: CATEye@naver.co.kr
</b>
</div>
</div>
</body>
</html>