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
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
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
		/* if(chatRoomList.size() > 0){
			for(int i=0; i<chatRoomList.size(); i++){
				_chatRoomVO = chatRoomList.get(i);
				Map<String, String> map = new HashMap<String, String>();
				map.put("roomName", _chatRoomVO.getMemName() + " 님과의 채팅");
				map.put("roomSeq", _chatRoomVO.getChatRoomSeq());
				map.put("roomDate", _chatRoomVO.getcDate());
			}
		} */
		return "chatRoomList";
	}
	
	// 채팅방 생성
	@RequestMapping("/regChatRoom.do")
	public String regChatRoom(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String inviteSeq = request.getParameter("inviteSeq");
		
		if("".equals(inviteSeq)){
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
	
	// 메시지 가져오기
}
