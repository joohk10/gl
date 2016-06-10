$(document).ready(function(){
	var _lastSeq = '';
	
	// ajax 함수
	$.jsonAjax = function(_url, _param, _func){
		$.ajax({
			url: _url,
			type: 'POST',
			data: _param,
			success: _func
		});
	};
	
	// 채팅로그 가져옴
	$.getChatLog = function(){
		var roomSeq = $("#roomSeq").val();
		var lastSeq = _lastSeq;
		var param = 'roomSeq=' + roomSeq + '&lastSeq=' + lastSeq;
		
		if(roomSeq == ''){
			return false;
		}
		
		$.jsonAjax('chatMsgRecv.do', param, function(data){
			//
		});
	};
	
	// 전송버튼 누름
	$("#chatSendBtn").click(function(){
		var roomSeq = $("#roomSeq").val();
		var sendMsg = encodeURIComponent($("#chatInput").val());
		var param = 'roomSeq=' + roomSeq + '&sendMsg=' + sendMsg;
		
		if(roomSeq == '' || sendMsg == ''){
			return false;
		}
		
		$.jsonAjax('chatMsgSend.do', param, function(data){
			var msg = $.parseJSON($.trim(data));
			if(msg.code == 'success'){
				$("#chatInput").val('');
			}else{
				alert(msg.msg);
			}
		});
	});
});