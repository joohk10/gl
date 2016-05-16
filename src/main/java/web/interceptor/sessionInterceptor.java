package web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class sessionInterceptor extends HandlerInterceptorAdapter {
		public boolean preHandle(HttpServletRequest request, 
				HttpServletResponse response, Object handler) throws Exception {
			
			// System.out.println("call session");
			HttpSession session = request.getSession();
			Map<String, String> memInfo = (Map<String, String>) session.getAttribute("memInfo");
			if(memInfo == null){
				response.sendRedirect("./index.do");
				return false;
			}
			String id = memInfo.get("id");
			// String name = memInfo.get("name");
			// String level = memInfo.get("level");
			
			if("".equals(id) || id == null){
				response.sendRedirect("./index.do");
				return false;
			}
			
			return super.preHandle(request, response, handler);
		}
}
