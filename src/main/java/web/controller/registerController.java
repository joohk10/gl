package web.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import java.io.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import web.service.memberService;
import web.service.memberVO;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@Controller
	public class registerController extends HttpServlet {
	    private static final long serialVersionUID = 1L;
		
	@Autowired
	protected memberService memberService;
	
	protected final static Logger log = Logger.getLogger(registerController.class);
	
	@RequestMapping("/register.do")
	
	public String regiAct(@ModelAttribute("memberVO")memberVO _memberVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		 
		String saveDir = request.getSession().getServletContext().getRealPath("/");
		int maxSize = 1024*1024*100;
		String encType = "UTF-8";

		MultipartRequest multi
		= new MultipartRequest(request, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		String num = multi.getParameter("num");
		String sex = multi.getParameter("sex");
		String hobby = multi.getParameter("hobby");
		String intro = multi.getParameter("introd");
		//String filen = request.getParameter("filen");
		
		_memberVO.setId(id);
		_memberVO.setPw(pw);
		_memberVO.setName(name);
		_memberVO.setnum(num);
		_memberVO.setsex(sex);
		_memberVO.sethobby(hobby);
		_memberVO.setintro(intro);
		
		File file = multi.getFile("filen");
		
	    memberService.insertUser(_memberVO);
		
		return "redirect:./index.do";
	}
}