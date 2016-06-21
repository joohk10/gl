package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import web.service.memberVO;

@Repository("memberDAO")
public class memberDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@SuppressWarnings("unchecked")
	public List<memberVO> selectUser(memberVO _memberVO) throws Exception {
		return sqlMapClientTemplate.queryForList("memberDAO.selectUser", _memberVO);
	}
	public List<memberVO> selectUserInfoBySeq(memberVO _memberVO) throws Exception {
		return sqlMapClientTemplate.queryForList("memberDAO.selectUserInfoBySeq", _memberVO);
	}
	public List<memberVO> searchUser(memberVO _memberVO) throws Exception {
		return sqlMapClientTemplate.queryForList("memberDAO.searchUser", _memberVO);
	}
	public List<memberVO> searchUsern(memberVO _memberVO) throws Exception {
		return sqlMapClientTemplate.queryForList("memberDAO.searchUsern", _memberVO);
	}
	public List<memberVO> searchgreen(memberVO _memberVO) throws Exception {
		return sqlMapClientTemplate.queryForList("memberDAO.searchgreen", _memberVO);
	}
	public void insertUser(memberVO _memberVO) throws Exception {
		sqlMapClientTemplate.insert("memberDAO.insertUser", _memberVO);
	}
	public void updateUser(memberVO _memberVO) throws Exception {
		sqlMapClientTemplate.update("memberDAO.updateUser", _memberVO);
	}
}
