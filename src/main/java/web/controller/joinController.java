package web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class joinController {
	
	protected final static Logger log = Logger.getLogger(joinController.class);
	
	@RequestMapping("/join.do")
	public String mainPage(HttpServletRequest request, ModelMap model) throws Exception{		
			return "join";
	}
	
	
}