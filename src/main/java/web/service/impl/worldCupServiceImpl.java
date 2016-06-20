package web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.service.memberVO;
import web.service.worldCupService;
import web.service.worldCupVO;

@Service
@Transactional
public class worldCupServiceImpl implements worldCupService {

	@Resource(name = "worldCupDAO")
	private worldCupDAO worldCupDAO;

	public List<worldCupVO> chkWorldCup(worldCupVO _worldCupVO) throws Exception {
		return worldCupDAO.chkWorldCup(_worldCupVO);
	}
	public List<memberVO> getWorldCupMember(worldCupVO _worldCupVO) throws Exception {
		return worldCupDAO.selectWorldCupMember(_worldCupVO);
	}
	public List<memberVO> getWorldCupOldMember(worldCupVO _worldCupVO) throws Exception {
		return worldCupDAO.selectWorldCupOldMember(_worldCupVO);
	}
	public void insertWorldCupLog(worldCupVO _worldCupVO) throws Exception {
		worldCupDAO.insertWorldCupLog(_worldCupVO);
	}
	public void updateWorldCupLog(worldCupVO _worldCupVO) throws Exception {
		worldCupDAO.updateWorldCupLog(_worldCupVO);
	}
}
