$(document).ready(function(){

	// get 파라메터 파싱
	$.parseURL = function(key){
		var url = location.href;
		var param = url.split("?");
		var res = "";
		if(param.length == 1){
			return "";
		}
		
		var paramList = param[param.length - 1].split("&");
		
		$.each(paramList, function(idx, val){
			var tmp = val.split("=");
			if(tmp[0] == key){
				res = tmp[1];
				return false;
			}
		});
		
		return res;
	};
	
	// 메시지 있을때 출력
	var msg = $.parseURL("msg");
	if(msg == "loginError"){
		alert("로그인중 오류가 발생하였습니다.");
	}else if(msg == "emptyParam"){
		alert("파라메터가 부족합니다.");
	}
});