$(document).ready(function(){
	var _mySeq = $("#mySeq").val();
	var _lastTime = '';
	var timer = null;
	
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
		var lastTime = _lastTime;
		var param = 'roomSeq=' + roomSeq + '&lastTime=' + lastTime;
		
		if(roomSeq == ''){
			return false;
		}
		
		$.jsonAjax('chatMsgRecv.do', param, function(data){
			var chatLog = $.parseJSON($.trim(data));
			$.each(chatLog.msgList, function(idx, val){
				$.addChatMsg(val.chatMsg, val.chatMemSeq);
				_lastTime = val.chatTime;
			});
		});
	};
	
	// 채팅 로그 추가
	$.addChatMsg = function(msg, seq){
		if(seq == _mySeq){
			var add = $('<li class="mMsg"><span class="chatMsg">' + msg + '</span></li>');
			$("#chatLog").append(add);
		}else{
			var add = $('<li class="fMsg"><span class="chatMsg">' + msg + '</span></li>');
			$("#chatLog").append(add);
		}
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
	
	$.getChatLog();
	timer = setInterval("$.getChatLog();", 1000);
});