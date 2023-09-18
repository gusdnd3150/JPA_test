package kr.co.sinbuya.www.web;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sinbuya.common.XPasswordEncoder;
import kr.co.sinbuya.entity.InvitationCelebrationMessage;
import kr.co.sinbuya.entity.InvitationMobile;
import kr.co.sinbuya.entity.ProductArticle;
import kr.co.sinbuya.repository.InvitationMobileRepository;
import kr.co.sinbuya.www.service.InvitationCelebrationMessageService;
import kr.co.sinbuya.www.service.ProductArticleService;
import kr.co.sinbuya.www.vo.InvitationCelebrationMessageVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired private InvitationMobileRepository invitationMobileRepository;
	@Autowired private ProductArticleService productArticleService;
	@Autowired private InvitationCelebrationMessageService invitationCelebrationMessageService;
	@Autowired private XPasswordEncoder oSecurity;
	

	private InvitationMobile getInvitation(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			URL url = new URL(request.getRequestURL().toString());
			String host = url.getHost();
			host = host.substring(0, host.indexOf("."));
			
			//host = "test02";			// 9376 (Celebration)		ㅇㅇd
			//host = "naru870805"; 		// 9384 (따뜻한 설렘)			ㅇㅇd
			//host = "test04";			// 9375 (봄편지)				ㅇㅇd
			//host = "test06"; 			// 9379 (보석처럼 아룸다운 그대 )	ㅇㅇd
			//host = "dbswn12";			// 9381 (장미빛 인생)			ㅇㅇd
			//host = "aaa11";			// 9377 (백년가약)				ㅇㅇd
			//host = "test98";			// 9394 (라비앙로즈)			ㅇㅇd
			//host = "test3";			// 9395 (보라빛 약속)			ㅇㅇd
			//host = "test05";			// 9397 (attractive)		ㅇㅇd
			//host = "test22";			// 9406 (marriage) 			ㅇㅇd
			//host = "test07";			// 9410 (스며들면 사랑)			ㅇㅇd
			//host = "test210901";		// 9413 (첫시작)				ㅇㅇd
			//host = "test60";			// 9418 (한결같은 사람)			ㅇㅇd
			//host = "test61";			// 9419 (눈부신 하루)			ㅇㅇd
			
			InvitationMobile result = invitationMobileRepository.getByUrl(host);

			return result;
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	@RequestMapping({"", "/{view}"})
	public String pages(HttpServletRequest request, HttpServletResponse response, ModelMap model, 
			@PathVariable(name = "view", required = false) String view,
			@RequestParam(value = "page", required = false) Integer page) {
		InvitationMobile row = getInvitation(request, response);
			

		if (row == null || row.isEnabled() == false) {
			if (view == null) {
				response.setStatus(404);
				response.setHeader( "Connection", "close" );
				return null;
			}
			else {
				return "redirect:/";
			}
		}
		else {
			ProductArticle article = productArticleService.findArticleById(row.getProductArticle().getId());
			if(article == null) {
				model.addAttribute("msg", "상품 오류 입니다.\n신부야 담당자에게 문의해주세요.");
				model.addAttribute("url", "https://www.sinbuya.com");
				return "/shared/redirect_with_message";
			}
			if(row.getMaxDate().before(new Date())) {
					//model.addAttribute("msg", "청첩장의 유효기간이 만료되었습니다.");
					model.addAttribute("url", "https://www.sinbuya.com");
					return "/shared/redirect_with_message";
			}
			if(row != null) {
				if(row.getGalleries().startsWith("[")) {
					JSONArray arr = JSONArray.fromObject(row.getGalleries());  //galleries를 제이슨Array로 형태로 변환 
					model.addAttribute("galleries",arr);
				}
			}			
			if(row.getAccountInfo().startsWith("[")) {
				JSONArray arr2 = JSONArray.fromObject(row.getAccountInfo());
				model.addAttribute("accounts", arr2);
			}			
			JSONObject obj = JSONObject.fromObject(row.getParent());
			model.addAttribute("parent", obj);
			model.addAttribute("skin", article.getId());
			model.addAttribute("row", row);
			model.addAttribute("message", invitationCelebrationMessageService.findByInvitationMobileId(row.getId()));
			
			return article.getId() + "/_index";
		}
	}
	
	
	@RequestMapping(value = "/messageinput/input.ajax", method = RequestMethod.POST)
	public ResponseEntity<String> messageInput(HttpServletRequest request, HttpServletResponse response,
			InvitationCelebrationMessageVO messageVO) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
		InvitationCelebrationMessage message = invitationCelebrationMessageService.saveMessage(messageVO);
		JSONObject object = new JSONObject();

		if (message != null) {
			object.put("success", true);
			object.put("id", message.getId());
			object.put("content", message.getContent());
			object.put("name", message.getName());
			object.put("created", new SimpleDateFormat("yyyy-MM-dd").format(message.getCreatedAt()));
		}
		return new ResponseEntity<String>(object.toString(), responseHeaders, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/messagedelete/delete.ajax", method = RequestMethod.POST)
	public ResponseEntity<String> messageDelete(HttpServletRequest request, HttpServletResponse response,
		@RequestParam("password") String password,
		@RequestParam(value = "id", required=false) long id){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
		
		InvitationCelebrationMessage result = invitationCelebrationMessageService.findById(id);
		
		JSONObject object = new JSONObject();
		if(result.getPassword().equals(oSecurity.encode(password))) {
			InvitationCelebrationMessage invitMessage = invitationCelebrationMessageService.deleteMessage(id);
			object.put("success", invitMessage != null);
		}else{
			object.put("success", false);
		}
		return new ResponseEntity<String>(object.toString(), responseHeaders, HttpStatus.OK);
	}
}	