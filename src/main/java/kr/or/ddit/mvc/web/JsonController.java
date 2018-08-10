package kr.or.ddit.mvc.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/json")
@Controller
public class JsonController {
	
	@ModelAttribute("rangers")
	public List<String> rangers() {					//public void rangers(Model model) { model.addAttribute("rangers", list) }  이방식으로도 가능
		List<String> list = new ArrayList<String>();
		list.add("brown");
		list.add("cony");
		list.add("sally");
		
		return list;
	}
	
	//rangers 리스트를 json응답으로 생성
	//localhost:8180/json/data
	@RequestMapping("/data")
	public String data(){
		
		return "jsonView";
		
		//지금까지는 jsp이름 리턴 (폴더를 포함한 경로와 jsp파일이름)
		//여기서는 view를 리턴할 것이다.
		//현재 viewResolver 설정상황
		// 1. 두개의 viewResolover가 등록
		//  1.1 order 0 : beanNameViewResolver
		//  1.2 order 1 : internalResourceViewResolver
	}
	
	
	//rangers 리스트를 json응답으로 생성(@ResponseBody)
	//localhost:8180/json/data/responseBody
	@RequestMapping("/data/responseBody")
	@ResponseBody
	public List<String> dataResponseBody(Model model) {
		@SuppressWarnings("unchecked")
		List<String> rangers = (List<String>) model.asMap().get("rangers");
		return rangers;
	}
	
	
	//json 요청테스트를 위한 view
	@RequestMapping("/requestView")
	public String requestView(){
		return "json/requestView";
	}
	
	
	@RequestMapping("/requestBody")
	@ResponseBody
	public List<String> requestBody(@RequestBody List<String> rangers){
//		for (String str : rangers) {
//			str = str + "_requestBody";
//		}
		
		for (int i = 0; i < rangers.size(); i++) {
			rangers.set(i, rangers.get(i) + UUID.randomUUID().toString());
		}
		
		return rangers;
	}
	
	
	//localhost:8180/json/excelData
	@RequestMapping("/excelData")
	public String excelData(){
		return "excelDownloadView";
	}
	
	
	//localhost:8180/
	//localhost:8180/json/fileDown
	@RequestMapping("/fileDown")
	public String fileDown(@RequestParam("fileName") String fileName, 
						   Model model){
		
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}

}
