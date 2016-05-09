package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping("/index.do")
	public String mainPage() throws Exception{
		return "index";  //tiles-def.xml의 definition name값
	}
}
