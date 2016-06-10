package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

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
	public void insertRoom(chatRoomVO _chatRoomVO) throws Exception {
		sqlMapClientTemplate.insert("chatDAO.insertRoom", _chatRoomVO);
	}
	public void insertRoomMember(chatRoomVO _chatRoomVO) throws Exception {
		sqlMapClientTemplate.insert("chatDAO.insertRoomMember", _chatRoomVO);
	}
	
}