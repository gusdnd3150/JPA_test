package kr.co.sinbuya.www.web;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ResourceController {

	@RequestMapping("/static-bundle/**")
	public String staticBundle(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
	
		String tpl = "shared/none";
		String url = request.getRequestURL().toString();
		url = url.substring(url.indexOf("static-bundle/") + 14);

		try {
			List<String> json = Files.readAllLines(Paths.get(this.getClass().getResource("/static-bundles.json").toURI()), Charset.defaultCharset());
			JSONObject object = JSONObject.fromObject(StringUtils.join(json, "").replaceAll("\\s+", " ").trim());
			
			JSONArray bundles = object.getJSONArray("bundles");
			for (Object o : bundles) {
				JSONObject bundle = (JSONObject) o;
				if (!bundle.getString("name").endsWith(url)) continue;
				tpl = "shared/static-bundles/" + bundle.getString("type");

				if (bundle.getString("type").equals("js")) {
					response.setContentType("text/javascript");
				}
				else {
					response.setContentType("text/" + bundle.getString("type"));
				}
				
				List<String> files = new ArrayList<String>();
				for (Object str : bundle.getJSONArray("files")) {
					String val = str.toString();
					if (val.startsWith("../")) {
						val = request.getContextPath() + val.substring(2);
					}
					else if (val.startsWith("/")) {
						val = request.getContextPath() + val;
					}
					else {
						val = request.getContextPath() + "/css/" + val;
					}
					files.add(val);
				}
				model.addAttribute("files", files);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return tpl;
	}
	
	@RequestMapping("/robots.txt")
	public String robots(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String host = request.getRequestURL().toString();
		model.addAttribute("document_uri", host.substring(0, host.indexOf("/", 10)));

		response.setContentType("text/plain");
		if(host.contains("sinbuyahall")) {
			return "dismiss/robots";
		}
		return "home/robots";
	}
	
	@RequestMapping(value = "/app_img/{m}/{id}", method = RequestMethod.GET)
	public String filedownload(HttpServletRequest request, @PathVariable ("m") String m, @PathVariable ("id") long id) throws IOException{
		String q = request.getQueryString();
		if (q == null) q = "";
		if (!q.isEmpty()) q = "?" + q;
		return "redirect:https://www.sinbuya.com/app_img/" + m + "/" + id + q;
	}
	
}
