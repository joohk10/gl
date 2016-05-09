package web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.service.TestService;
import web.service.testVO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@Autowired
	protected TestService testService;
	
	protected final static Logger log = Logger.getLogger(indexController.class);
	
	@RequestMapping("/index.do")
	public String mainPage(@ModelAttribute("testVO")testVO _testVO, 
			HttpServletRequest request, ModelMap model) throws Exception{
	
		Map<String, Object> map = testService.list(_testVO);
		
		model.addAttribute("list", map.get("List"));
		
		return "main";
	}
}
