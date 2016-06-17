package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.worldCupService;

@Controller
public class worldCupController {

	protected final static Logger log = Logger.getLogger(chatController.class);
	
	@Autowired
	protected worldCupService worldCupService;
	
	// 이상형 월드컵 메인 페이지
	@RequestMapping("/worldCup.do")
	public String worldCup(HttpServletRequest request, ModelMap model) throws Exception{
		
		// 오늘 했는지 체크
		
		// 8명 선택
		
		// js, css 추가
		
		return "worldCup";
	}
	
	// 이상형 월드컵 종료.
	@RequestMapping("/worldCupRes.do")
	public String worldCupRes(HttpServletRequest request, ModelMap model) throws Exception{
		return "worldCupRes";
	}
}
