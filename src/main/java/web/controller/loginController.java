package web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
	
	protected final static Logger log = Logger.getLogger(indexController.class);
	
	@RequestMapping("/login.do")
	
	public String mainPage(HttpServletRequest request, ModelMap model) throws Exception{
		
		HttpSession session = request.getSession();
		Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
		if(memInfo != null){
			String id = memInfo.get("id");
			String name = memInfo.get("name");
			
			model.addAttribute("uId", id);
			model.addAttribute("uName", name);
			
			return "login";
		}else{
			return "not_login";
		}
	}
}
