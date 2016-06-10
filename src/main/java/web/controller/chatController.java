package web.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.net.aso.MD5;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.chatLogVO;
import web.service.chatRoomVO;
import web.service.chatService;
import web.service.memberService;
import web.service.memberVO;

@Controller
public class chatController {

	protected final static Logger log = Logger.getLogger(chatController.class);
	
	@Autowired
	protected chatService chatService;
	@Autowired
	protected memberService memberService;
	
	// 해쉬 생성
	public String getHash(String _str){
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(_str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		return MD5;
	}
	
	// 날짜 스트링
	public String getDateStr(){
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd S");
		Date nowDate = new Date();
		String tempDate = sdFormat.format(nowDate);
		return tempDate;
	}
	
	// 채팅방 리스트
	@RequestMapping("/chatRoomList.do")
	public String chatRoomList(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		
		chatRoomVO _chatRoomVO = new chatRoomVO();
		_chatRoomVO.setMemId(memInfo.get("id"));
		
		List<chatRoomVO> chatRoomList = chatService.getRoomList(_chatRoomVO);
		model.addAttribute("chatRoomList", chatRoomList);
		
		// css 설정
		String customCss[] = { "css/chat.css" };
		model.addAttribute("customCss", customCss);
		return "chatRoomList";
	}
	
	// 채팅방
	@RequestMapping("/chatRoom.do")
	public String chatRoom(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String roomSeq = request.getParameter("seq");
		
		if("".equals(roomSeq) || roomSeq == null){
			return "redirect:./index.do?msg=emptyParam";
		}
		
		chatRoomVO _chatRoomVO = new chatRoomVO();
		_chatRoomVO.setMemId(memInfo.get("id"));
		_chatRoomVO.setChatRoomSeq(roomSeq);
		
		List<chatRoomVO> chkRoomMember = chatService.chkRoomMember(_chatRoomVO);
		if(Integer.parseInt(chkRoomMember.get(0).getCnt()) == 0){
			return "redirect:./index.do?msg=roomError";
		}
		
		model.addAttribute("roomSeq", roomSeq);
		
		// css 설정
		String customCss[] = { "css/chat.css" };
		model.addAttribute("customCss", customCss);
		
		// js 설정
		String customJs[] = { "js/chat.js" };
		model.addAttribute("customJs", customJs);
		return "chatRoom";
	}
	
	// 채팅방 생성
	@RequestMapping("/regChatRoom.do")
	public String regChatRoom(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String inviteSeq = request.getParameter("inviteSeq");
		
		if("".equals(inviteSeq) || inviteSeq == null){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "잘못된 요청입니다.");
			return "jsonMsg"; // error
		}
		
		memberVO _memberVO = new memberVO();
		_memberVO.setSeq(inviteSeq);
		
		List<memberVO> userInfo = memberService.getUserInfoBySeq(_memberVO);
		if(userInfo.size() == 0){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "잘못된 요청입니다.");
			return "jsonMsg"; // error
		}
		
		// 생성된 방 확인
		chatRoomVO _chatRoomVO = new chatRoomVO();
		_chatRoomVO.setHostSeq(memInfo.get("seq"));
		_chatRoomVO.setGuestSeq(inviteSeq);
		List<chatRoomVO> chkRoom = chatService.chkRoomState(_chatRoomVO);
		if(chkRoom.size() != 0){
			if(Integer.parseInt(chkRoom.get(0).getCnt()) > 1){
				model.addAttribute("code", "error");
				model.addAttribute("msg", "이미 생성되었습니다.");
				return "jsonMsg"; // error
			}
		}
		
		// 생성
		String roomSeq = getHash(memInfo.get("seq") + inviteSeq);
		String hostSeq = getHash(memInfo.get("seq") + getDateStr());
		String guestSeq = getHash(inviteSeq + getDateStr());
		
		_chatRoomVO.setChatRoomSeq(roomSeq);
		_chatRoomVO.setcDate(getDateStr());
		chatService.insertRoom(_chatRoomVO);
		
		_chatRoomVO.setChatRoomSeq(roomSeq);
		_chatRoomVO.setChatMemSeq(hostSeq);
		_chatRoomVO.setMemSeq(memInfo.get("seq"));
		chatService.insertRoomMember(_chatRoomVO);
		
		_chatRoomVO.setChatRoomSeq(roomSeq);
		_chatRoomVO.setChatMemSeq(guestSeq);
		_chatRoomVO.setMemSeq(inviteSeq);
		chatService.insertRoomMember(_chatRoomVO);

		model.addAttribute("code", "success");
		model.addAttribute("msg", "");
		return "jsonMsg";
	}
	
	// 메시지 보내기
	@RequestMapping("/chatMsgSend.do")
	public String chatMsgSend(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String roomSeq = request.getParameter("roomSeq");
		String msg = request.getParameter("sendMsg");
		
		// 파라메터 체크
		if("".equals(roomSeq) || roomSeq == null || "".equals(msg) || msg == null){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "에러가 발생하였습니다.");
			return "jsonMsg";
		}
		
		// 채팅방 맴버 확인
		chatRoomVO _chatRoomVO = new chatRoomVO();
		_chatRoomVO.setMemId(memInfo.get("id"));
		_chatRoomVO.setChatRoomSeq(roomSeq);
		
		List<chatRoomVO> chkRoomMember = chatService.chkRoomMember(_chatRoomVO);
		if(Integer.parseInt(chkRoomMember.get(0).getCnt()) == 0){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "에러가 발생하였습니다.");
			return "jsonMsg";
		}
		
		// 채팅 로그 남기기
		chatLogVO _chatLogVO = new chatLogVO();
		_chatLogVO.setChatLogSeq(getHash(getDateStr()));
		_chatLogVO.setChatMemSeq(memInfo.get("seq"));
		_chatLogVO.setChatMsg(msg);
		_chatLogVO.setChatRoomSeq(roomSeq);
		chatService.insertMsgLog(_chatLogVO);
		
		model.addAttribute("code", "success");
		model.addAttribute("msg", "");
		return "jsonMsg";
	}
	
	// 메시지 가져오기
	@RequestMapping("/chatMsgRecv.do")
	public String chatMsgRecv(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String roomSeq = request.getParameter("roomSeq");
		String lastMsg = request.getParameter("lastMsg");
		
		if("".equals(roomSeq) || roomSeq == null){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "");
			return "jsonMsg";
		}
		
		// 채팅방 맴버 확인
		chatRoomVO _chatRoomVO = new chatRoomVO();
		_chatRoomVO.setMemId(memInfo.get("id"));
		_chatRoomVO.setChatRoomSeq(roomSeq);
		
		List<chatRoomVO> chkRoomMember = chatService.chkRoomMember(_chatRoomVO);
		if(Integer.parseInt(chkRoomMember.get(0).getCnt()) == 0){
			model.addAttribute("code", "error");
			model.addAttribute("msg", "에러가 발생하였습니다.");
			return "jsonMsg";
		}

		chatLogVO _chatLogVO = new chatLogVO();
		List<chatLogVO> _chatLogList = null;
		if("".equals(lastMsg) || lastMsg == null){
			// 마지막 100개 불러옴
			_chatLogVO.setChatRoomSeq(roomSeq);
			_chatLogList = chatService.getChatList(_chatLogVO);
			model.addAttribute("type", "firstLoad");
		}else{
			// lastMsg 이후 내용 가져옴
			model.addAttribute("type", "getLastMsg");
		}
		
		model.addAttribute("chatLog", _chatLogList);
		return "jsonChatMsg";
	}
}
