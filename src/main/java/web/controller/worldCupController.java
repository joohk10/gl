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

		worldCupVO _worldCupVO = new worldCupVO();
		List<memberVO> memberList = null;
		List<worldCupVO> worldCupList = null;
		
		// 오늘 했는지 체크
		_worldCupVO.setLogDate(getDateStr("yyyyMMdd"));
		_worldCupVO.setHostMemSeq(memInfo.get("seq"));
		worldCupList = worldCupService.chkWorldCup(_worldCupVO);
		if(worldCupList.size() == 0){
			// 신규 8명 선택
			_worldCupVO.setHostMemSeq(memInfo.get("seq"));
			memberList = worldCupService.getWorldCupMember(_worldCupVO);
			
			if(memberList.size() < 1){
				return "worldCup";
			}
			// 로그 입력.
			for(int i=0; i<8; i++){
				memberVO tmp = memberList.get(i);
				_worldCupVO.setHostMemSeq(memInfo.get("seq"));
				_worldCupVO.setMemSeq(tmp.getSeq());
				_worldCupVO.setWorldCupSeq(getHash(getDateStr()));
				worldCupService.insertWorldCupLog(_worldCupVO);
			}
		}else if(Integer.parseInt(worldCupList.get(0).getCnt()) > 0){
			String chk = worldCupList.get(0).getChk(); 
			if("Y".equals(chk)){
				model.addAttribute("msg", "오늘은 이미 진행하였습니다.");
				return "errorAlert";
			}
			// 이전 8명 선택
			_worldCupVO.setHostMemSeq(memInfo.get("seq"));
			memberList = worldCupService.getWorldCupOldMember(_worldCupVO);
		}
		model.addAttribute("memberList", memberList);
		
		// js, css 추가
		String customJs[] = { "js/worldCup.js" };
		model.addAttribute("customJs", customJs);
		String customCss[] = { "css/worldCup.css" };
		model.addAttribute("customCss", customCss);
		
		return "worldCup";
	}
	
	// 이상형 월드컵 종료.
	@RequestMapping("/worldCupRes.do")
	public String worldCupRes(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		
		worldCupVO _worldCupVO = new worldCupVO();
		_worldCupVO.setHostMemSeq(memInfo.get("seq"));
		worldCupService.updateWorldCupLog(_worldCupVO);
		
		return "redirect:./chatRoomList.do";
	}
}
