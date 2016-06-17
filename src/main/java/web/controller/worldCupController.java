package web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.memberVO;
import web.service.worldCupService;
import web.service.worldCupVO;

@Controller
public class worldCupController extends commonController {

	protected final static Logger log = Logger.getLogger(worldCupController.class);
	
	@Autowired
	protected worldCupService worldCupService;
	
	// 이상형 월드컵 메인 페이지
	@RequestMapping("/worldCup.do")
	public String worldCup(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		
		// 오늘 했는지 체크
		
		// 8명 선택
		worldCupVO _worldCupVO = new worldCupVO();
		_worldCupVO.setHostMemSeq(memInfo.get("seq"));
		List<memberVO> memberList = worldCupService.getWorldCupMember(_worldCupVO);
		model.addAttribute("memberList", memberList);
		
		// js, css 추가
		
		return "worldCup";
	}
	
	// 이상형 월드컵 종료.
	@RequestMapping("/worldCupRes.do")
	public String worldCupRes(HttpServletRequest request, ModelMap model) throws Exception{
		return "worldCupRes";
	}
}
