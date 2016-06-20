package web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.service.greenLightService;
import web.service.greenLightVO;

@Service
@Transactional
public class greenLightServiceImpl implements greenLightService {

	@Resource(name = "greenLightDAO")
	private greenLightDAO greenLightDAO;
	
	public List<greenLightVO> chkGreenLight(greenLightVO _greenLightVO) throws Exception {
		return greenLightDAO.chkGreenLight(_greenLightVO);
	}
	
	public List<greenLightVO> chkDoubleLight(greenLightVO _greenLightVO) throws Exception {
		return greenLightDAO.chkDoubleLight(_greenLightVO);
	}
	
	public List<greenLightVO> countLight(greenLightVO _greenLightVO) throws Exception {
		return greenLightDAO.countLight(_greenLightVO);
	}
	
	public void insertGreenLight(greenLightVO _greenLightVO) throws Exception {
		greenLightDAO.insertGreenLight(_greenLightVO);
	}

}
