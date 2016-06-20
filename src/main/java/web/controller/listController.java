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

import web.service.memberService;
import web.service.memberVO;

@Controller
public class listController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected memberService memberService;
	
	protected final static Logger log = Logger.getLogger(indexController.class);
	@RequestMapping("/list.do")
	public String regiAct(@ModelAttribute("memberVO")memberVO _memberVO, HttpServletRequest request, ModelMap model) throws Exception
	{	
		List<memberVO> list = memberService.searchgreen(_memberVO);
		
		
		for(int i=0;i<10;i++)
		{
			int wseq = list.get(i);
			List<memberVO> list = memberService.searchgreen(_memberVO);
				Map<String, String> map = new HashMap<String, String>();
				map.put("seq", memInfo.getSeq());
				map.put("id", memInfo.getId());
				map.put("name", memInfo.getName());
				map.put("level", memInfo.getMlevel());
				request.getSession().setAttribute("memInfo", map);
				return "redirect:./search.do";
			}
		return "redirect:./search.do";
	}
}