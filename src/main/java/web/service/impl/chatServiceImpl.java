package web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.service.chatLogVO;
import web.service.chatRoomVO;
import web.service.chatService;

@Service
@Transactional
public class chatServiceImpl implements chatService {

	@Resource(name = "chatDAO")
	private chatDAO chatDAO;
	
	public List<chatRoomVO> getRoomList(chatRoomVO _chatRoomVO) throws Exception {
		return chatDAO.selectRoomList(_chatRoomVO);
	}

	public List<chatRoomVO> chkRoomState(chatRoomVO _chatRoomVO) throws Exception {
		return chatDAO.chkRoomList(_chatRoomVO);
	}

	public List<chatRoomVO> chkRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		return chatDAO.chkRoomMember(_chatRoomVO);
	}

	public List<chatLogVO> getChatList(chatLogVO _chatLogVO) throws Exception {
		return chatDAO.getChatList(_chatLogVO);
	}

	public void insertRoom(chatRoomVO _chatRoomVO) throws Exception {
		chatDAO.insertRoom(_chatRoomVO);
	}

	public void insertRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		chatDAO.insertRoomMember(_chatRoomVO);
	}

	public void insertMsgLog(chatLogVO _chatLogVO) throws Exception {
		chatDAO.insertMsgLog(_chatLogVO);
	}

}
