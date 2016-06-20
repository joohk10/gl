package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import web.service.greenLightVO;

@Repository("greenLightDAO")
public class greenLightDAO {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<greenLightVO> chkGreenLight(greenLightVO _greenLightVO) throws Exception{
		return sqlMapClientTemplate.queryForList("greenLightDAO.chkGreenLight", _greenLightVO);
	}
	
	public List<greenLightVO> chkDoubleLight(greenLightVO _greenLightVO) throws Exception {
		return sqlMapClientTemplate.queryForList("greenLightDAO.chkDoubleLight", _greenLightVO);
	}

	public List<greenLightVO> countLight(greenLightVO _greenLightVO) throws Exception {
		return sqlMapClientTemplate.queryForList("greenLightDAO.countLight", _greenLightVO);
	}
	
	public void insertGreenLight(greenLightVO _greenLightVO) throws Exception {
		sqlMapClientTemplate.insert("greenLightDAO.insertGreenLight", _greenLightVO);
	}
}
