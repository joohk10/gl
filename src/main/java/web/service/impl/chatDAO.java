package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import web.service.chatLogVO;
import web.service.chatRoomVO;

@Repository("chatDAO")
public class chatDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<chatRoomVO> selectRoomList(chatRoomVO _chatRoomVO) throws Exception {
		return sqlMapClientTemplate.queryForList("chatDAO.selectChatList", _chatRoomVO);
	}
	public List<chatRoomVO> chkRoomList(chatRoomVO _chatRoomVO) throws Exception {
		return sqlMapClientTemplate.queryForList("chatDAO.chkChatList", _chatRoomVO);
	}
	public List<chatRoomVO> chkRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		return sqlMapClientTemplate.queryForList("chatDAO.chkRoomMember", _chatRoomVO);
	}
	public List<chatLogVO> getChatList(chatLogVO _chatLogVO) throws Exception {
		return sqlMapClientTemplate.queryForList("chatDAO.getChatList", _chatLogVO);
	}
	public List<chatLogVO> getChatListUTime(chatLogVO _chatLogVO) throws Exception {
		return sqlMapClientTemplate.queryForList("chatDAO.getChatListUTime", _chatLogVO);
	}
	public void insertRoom(chatRoomVO _chatRoomVO) throws Exception {
		sqlMapClientTemplate.insert("chatDAO.insertRoom", _chatRoomVO);
	}
	public void insertRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		sqlMapClientTemplate.insert("chatDAO.insertRoomMember", _chatRoomVO);
	}
	public void insertMsgLog(chatLogVO _chatLogVO) throws Exception {
		sqlMapClientTemplate.insert("chatDAO.insertMsgLog", _chatLogVO);
	}
	
}
