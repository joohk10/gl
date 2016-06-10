package web.service;

import java.util.List;

public interface chatService {

	public List<chatRoomVO> getRoomList(chatRoomVO _chatRoomVO) throws Exception;
	public List<chatRoomVO> chkRoomState(chatRoomVO _chatRoomVO) throws Exception;
	public void insertRoom(chatRoomVO _chatRoomVO) throws Exception;
	public void insertRoomMember(chatRoomVO _chatRoomVO) throws Exception;
}
