package kr.co.sinbuya.common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WebInterceptor implements HandlerInterceptor {
	
	@Autowired private SinbuyaHelper sb;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		response.setHeader("Access-Control-Allow-Origin", "*");
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("application.properties").getFile());
		
		request.setAttribute("_dt", "?" + file.lastModified());

		String url = request.getRequestURI();
		url = url.substring(request.getContextPath().length());
		CookieHelper cookie = new CookieHelper(request, response);
		if (!url.startsWith("/sync") && !url.endsWith(".json") && !url.endsWith(".css")
				&& !url.endsWith(".js") && !url.endsWith("/error")) {
			
			String str = cookie.getCookie("r");
			String ref = request.getHeader("Referer");
			if (str == null || !str.isEmpty()) {
				if (ref != null && !ref.contains("sinbuya.com") && !ref.contains("localhost")) {
					cookie.setCookie("r", ref);
				}
			}			
			
		}
		
		request.setAttribute("sb", sb);
		
		return true;
	}


	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

}
