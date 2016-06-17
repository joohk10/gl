package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import web.service.memberVO;
import web.service.worldCupVO;

@Repository("worldCupDAO")
public class worldCupDAO {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<memberVO> selectWorldCupMember(worldCupVO _worldCupVO) throws Exception {
		return sqlMapClientTemplate.queryForList("worldCupDAO.selectWorldCupMember", _worldCupVO);
	}
}
