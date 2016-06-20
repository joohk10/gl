package web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.chatRoomVO;
import web.service.chatService;
import web.service.greenLightService;
import web.service.greenLightVO;
import web.service.worldCupService;
import web.service.worldCupVO;

@Controller
public class greenController extends commonController {

	protected final static Logger log = Logger.getLogger(greenLightController.class);
	
	@Autowired
	protected greenLightService greenLightService;
	@Autowired
	protected chatService chatService;
	@Autowired
	protected worldCupService worldCupService;
	
	// 이상형 월드컵 그린 라이트 종료.
	@RequestMapping("green.do")
	public String greenLightWorldCup(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		
		// 그린라이트 보냄
		String seq = request.getParameter("seq");
		
		greenLightVO _greenLightVO = new greenLightVO();
		_greenLightVO.setFromw(memInfo.get("seq"));
		_greenLightVO.setTow(seq);
		
		List<greenLightVO> greenLightVO = greenLightService.chkGreenLight(_greenLightVO);
		if(Integer.parseInt(greenLightVO.get(0).getCnt()) == 0){
			// 그린라이트 입력
			_greenLightVO.setSeq(getHash(getDateStr()));
			_greenLightVO.setFromw(memInfo.get("seq"));
			_greenLightVO.setTow(seq);
			greenLightService.insertGreenLight(_greenLightVO);
			
			// 그린라이트 체크
			_greenLightVO.setFromw(memInfo.get("seq"));
			_greenLightVO.setTow(seq);
			greenLightVO = greenLightService.chkDoubleLight(_greenLightVO);
			if(Integer.parseInt(greenLightVO.get(0).getCnt()) > 1){
				// 채팅방 개설
				// 있는지 확인
				chatRoomVO _chatRoomVO = new chatRoomVO();
				_chatRoomVO.setHostSeq(memInfo.get("seq"));
				_chatRoomVO.setGuestSeq(seq);
				List<chatRoomVO> chkRoom = chatService.chkRoomState(_chatRoomVO);
				if(chkRoom.size() == 0){
					// 없으면 만듬
					String roomSeq = getHash(memInfo.get("seq") + seq);
					String hostSeq = getHash(memInfo.get("seq") + getDateStr());
					String guestSeq = getHash(seq + getDateStr());
					
					_chatRoomVO.setChatRoomSeq(roomSeq);
					chatService.insertRoom(_chatRoomVO);
					
					_chatRoomVO.setChatRoomSeq(roomSeq);
					_chatRoomVO.setChatMemSeq(hostSeq);
					_chatRoomVO.setMemSeq(memInfo.get("seq"));
					chatService.insertRoomMember(_chatRoomVO);
					
					_chatRoomVO.setChatRoomSeq(roomSeq);
					_chatRoomVO.setChatMemSeq(guestSeq);
					_chatRoomVO.setMemSeq(seq);
					chatService.insertRoomMember(_chatRoomVO);
					
					return "redirect:./chatRoomList.do";
				}
			}
		}
		
		return "redirect:./index.do";
	}
}
