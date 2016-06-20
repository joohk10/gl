$(document).ready(function(){
	var rank = $(".pList li").length;
	// 두개 선택!!
	$.selectUser = function(){
		$(".pList li").addClass("notView").removeClass("worldCupLeftPos").removeClass("worldCupRightPos");
		var selector = $(".pList li.r" + (rank*2) + "s:not(.r" + rank + ")");
		$("h1").text(rank + "강");
		if(selector.length < 2){
			if(rank < 1){
				return ;
			}
			rank = rank / 2;
			$.selectUser();
			return ;
		}
		$(selector[0]).removeClass("notView").addClass("r" + rank).addClass("worldCupLeftPos");
		$(selector[1]).removeClass("notView").addClass("r" + rank).addClass("worldCupRightPos");
		return ;
	};
	
	// 월드컵 끝
	$.worldCupEnd = function(seq){
		if(confirm("그린라이트를 보내시겠습니까?")){
			$.jsonAjax('greenLightWorldCup.do', 'seq=' + seq, function(data){
				location.href = './search.do';
			});
		}else{
			$.jsonAjax('worldCupRes.do', 'seq=' + seq, function(data){
				location.href = './search.do';
			});
		}
	};
	
	$(".pList li").click(function(){
		$(this).addClass("r" + rank + "s");
		if(rank > 3){
			$.selectUser();
		}else{
			$.worldCupEnd($(this).attr("seq"));
		}
	});
	
	$.selectUser();
});