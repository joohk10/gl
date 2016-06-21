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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import web.service.memberVO;
import web.service.memberService;

@Controller
public class memberController {
	
	@Autowired
	protected memberService memberService;

	protected final static Logger log = Logger.getLogger(memberController.class);
	
	@RequestMapping("/editMember.do")
	public String editMember(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		String seq = memInfo.get("seq");
		
		memberVO _memberVO = new memberVO();
		_memberVO.setSeq(seq);
		List<memberVO> memInfoRes = memberService.getUserInfoBySeq(_memberVO);
		model.addAttribute("memInfo", memInfoRes.get(0));
		return "editMember";
	}
	
	@RequestMapping("/editMemberAct.do")
	public String editMemberAct(@ModelAttribute("memberVO")memberVO _memberVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		
		String saveDir = request.getSession().getServletContext().getRealPath("/");
		int maxSize = 1024*1024*100;
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encType,new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		String num = multi.getParameter("num");
		String sex = multi.getParameter("sex");
		String hobby = multi.getParameter("hobby");
		String intro = multi.getParameter("introd");
		String filen = multi.getFilesystemName("filen");
		
		if("".equals(id) || id == null ||
				"".equals(pw) || pw == null ||
				"".equals(name) || name == null ||
				"".equals(num) || num == null ||
				"".equals(sex) || sex == null ||
				"".equals(hobby) || hobby == null ||
				"".equals(intro) || intro == null ||
				"".equals(filen) || filen == null){
			model.addAttribute("msg", "내용을 모두 채워주세요");
			return "errorAlert";
		}
		
		_memberVO.setSeq(memInfo.get("seq"));
		_memberVO.setId(id);
		_memberVO.setPw(pw);
		_memberVO.setName(name);
		_memberVO.setnum(num);
		_memberVO.setsex(sex);
		_memberVO.sethobby(hobby);
		_memberVO.setintro(intro);
		_memberVO.setFilen(filen);
		
		memberService.updateUser(_memberVO);
		
		model.addAttribute("msg", "수정되었습니다");
		model.addAttribute("move", "index.do");
		return "errorAlert";
	}
	
	@RequestMapping("/loginAct.do")
	public String loginAct(@ModelAttribute("memberVO")memberVO _memberVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if("".equals(id) || id == null || "".equals(pw) || pw == null){
			return "redirect:./index.do?msg=emptyParam";
		}
		
		_memberVO.setId(id);
		_memberVO.setPw(pw);
		List<memberVO> list = memberService.getUser(_memberVO);
		if(list.size() == 1){
			memberVO memInfo = list.get(0);
			if(memInfo.getId().equals(id) && memInfo.getPw().equals(pw)){
				Map<String, String> map = new HashMap<String, String>();
				map.put("seq", memInfo.getSeq());
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