package web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public int chkRoomState(chatRoomVO _chatRoomVO) throws Exception {
		return chatDAO.chkRoomList(_chatRoomVO);
	}

	public void insertRoom(chatRoomVO _chatRoomVO) throws Exception {
		chatDAO.insertRoom(_chatRoomVO);
	}

	public void insertRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		chatDAO.insertRoomMember(_chatRoomVO);
	}

}
