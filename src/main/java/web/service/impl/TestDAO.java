package web.service.impl;

import java.util.List;

import web.service.testVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("TestDAO")
public class TestDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@SuppressWarnings("unchecked")
	public List<testVO> selectEmpList(testVO _testVO) throws Exception {
		return sqlMapClientTemplate.queryForList("testDAO.selectEmpList", _testVO);
	}
}
