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
}
