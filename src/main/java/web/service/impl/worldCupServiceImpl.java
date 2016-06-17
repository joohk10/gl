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

	public List<memberVO> getWorldCupMember(worldCupVO _worldCupVO) throws Exception {
		return worldCupDAO.selectWorldCupMember(_worldCupVO);
	}
}
