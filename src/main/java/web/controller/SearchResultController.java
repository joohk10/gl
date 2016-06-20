package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
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
public class SearchResultController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
@Autowired
protected memberService memberService;

protected final static Logger log = Logger.getLogger(SearchResultController.class);

@RequestMapping("/SearchResult.do")

public String regiAct(@ModelAttribute("memberVO")memberVO _memberVO, HttpServletRequest request, ModelMap model) throws Exception
{
	String sel = request.getParameter("sel");
	String search = request.getParameter("search");
	
	_memberVO.setSearch(search);
	
	if("1".equals(sel))
	{
		List<memberVO> searchlist = memberService.searchUser(_memberVO);
		model.addAttribute("searchlist", searchlist);
	}
	else
	{
		List<memberVO> searchlist = memberService.searchUsern(_memberVO);
		model.addAttribute("searchlist", searchlist);
	}
	
	return "search";
}
}