package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.greenLightService;
import web.service.greenLightVO;
import web.service.memberService;
import web.service.memberVO;

@Controller
public class listController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected memberService memberService;
	protected greenLightService greenLightService;
	
	protected final static Logger log = Logger.getLogger(indexController.class);
	@RequestMapping("/list.do")
	public String regiAct(@ModelAttribute("memberVO")memberVO _memberVO, HttpServletRequest request, ModelMap model) throws Exception
	{	
		HttpSession session = request.getSession();
		
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		if(memInfo != null){
			String seq = memInfo.get("seq");
			
			_memberVO.setSeq(seq);
			
			List<memberVO> greenlist = memberService.searchgreen(_memberVO);
			List<greenLightVO> greencount = greenLightService.countLight(_greenLightVO);
			
			model.addAttribute("greenlist", greenlist);
		}	
		return "list";
	}
}