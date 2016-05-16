package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.memberVO;
import web.service.memberService;

@Controller
public class memberController {
	
	@Autowired
	protected memberService memberService;

	protected final static Logger log = Logger.getLogger(memberController.class);
	
	@RequestMapping("/loginAct.do")
	public String loginAct(@ModelAttribute("memberVO")memberVO _memberVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if("".equals(id) || "".equals(pw)){
			return "redirect:./index.do?msg=emptyParam";
		}
		
		_memberVO.setId(id);
		_memberVO.setPw(pw);
		List<memberVO> list = memberService.getUser(_memberVO);
		if(list.size() == 1){
			memberVO memInfo = list.get(0);
			if(memInfo.getId().equals(id) && memInfo.getPw().equals(pw)){
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", memInfo.getId());
				map.put("name", memInfo.getName());
				map.put("level", memInfo.getMlevel());
				request.getSession().setAttribute("memInfo", map);
				return "redirect:./index.do";
			}
		}
		return "redirect:./index.do?msg=loginError";
	}
	
	@RequestMapping("/logoutAct.do")
	public String logoutAct(HttpServletRequest request, ModelMap model) throws Exception{
		request.getSession().invalidate();
		return "redirect:./index.do";
	}
}
