package web.controller;

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
public class registerController {
	
	@Autowired
	protected memberService memberService;
	
	protected final static Logger log = Logger.getLogger(registerController.class);
	
	@RequestMapping("/register.do")
	
	public String regiAct(@ModelAttribute("memberVO")memberVO _memberVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		String filen = request.getParameter("filen");
		
		_memberVO.setId(id);
		_memberVO.setPw(pw);
		_memberVO.setName(name);
		_memberVO.setnum(num);
		
		memberService.insertUser(_memberVO);
		
		return "redirect:./index.do";
	}
}