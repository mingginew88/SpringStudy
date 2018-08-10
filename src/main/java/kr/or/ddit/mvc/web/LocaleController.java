package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/locale")
@Controller
public class LocaleController {
	
	//국제화 코드를 담을 map을 생성하는 modelAttribute 생성
	//	<option value="ko">한국어</option>
	//	<option value="ja">日本の語</option>
	//	<option value="en">English</option>
	
	@ModelAttribute("localeMap")
	public Map<String, String> localeMap() {
		Map<String, String> localeMap = new HashMap<String, String>();
		
		localeMap.put("ko", "한국어");
		localeMap.put("en", "english");
		localeMap.put("ja", "日本の語");
		
		return localeMap;
	}
	
	
	@RequestMapping("/view")
	public String view(){
		return "locale/view";
	}
	
	/*
	 * 어떤 view resolver에서 처리될지를 결정 : servlet-context.xml에 설정한 view resolver와 우선순위에 따라 결정
	 * 
	 * 우리가 설정한 상황
	 * beanNameViewResolver 		: priority 1
	 * tilesViewResolver 			: priority 2
	 * internalResourceViewResolver : priority 3
	 * 
	 * view 이름으로 "locale/view"를 controller에서 리턴한 경우
	 * 1. beanNameViewResolver에 의해 스프링 빈 중 "locale/view"를 갖는 view가 등록되었는지 확인
	 * 	 --> bean이 존재하지 않음 --> 다음 viewResolvber로 이동
	 * 	 ** "jsonView" , "excelDownloadView", "fileDownloadView"
	 * 
	 * 2. tilesViewResolver를 통해 tiles-config.xml에 설정된 definition name을 "locale/view"와 일치하는 definition이 존재하는지 확인
	 *   --> name 일치하는 definition이 존재하지않음 --> 다음 viewResolver로 이동
	 *   
	 *   
	 * 3. internalResourceViewResolver
	 *   internalResourceViewResolver는 해당 리소스가 존재하는지 여부 확인하지 않고
	 *   prefix + viewName + surfix로 forward 처리함
	 *   --> viewName에 해당하는 리소스가 없을 경우 404에러
	 * 
	 */

}
