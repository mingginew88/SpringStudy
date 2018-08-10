package kr.or.ddit.mvc.web;

import javax.validation.Valid;

import kr.or.ddit.mvc.model.ValidJsr303Vo;
import kr.or.ddit.mvc.model.ValidVo;
import kr.or.ddit.mvc.model.ValidVoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/valid")
@Controller
public class ValidatorController {
	//첫번째와 두번째를 가장 많이 사용한다 첫번째 방법을 추천해주심..
	
	@RequestMapping("/view")
	public String view(){
		return "mvc/valid/view";
	}
	
	@RequestMapping("/submit")
	//bindingResult는 반드시 vo 객체 바로 뒤에 선언 되어야 한다. 
	public String submit(ValidVo validVo, 
						 BindingResult errors, 
						 Model model){
		
		new ValidVoValidator().validate(validVo, errors);
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	
	//jsr303
	@RequestMapping("/submit/jsr303")
	//bindingResult는 반드시 vo 객체 바로 뒤에 선언 되어야 한다. 
	public String submitJsr303(@Valid ValidJsr303Vo validVo, 
						 BindingResult errors, 
						 Model model){
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	
	//spring validator + jsr303 @Valid
	@RequestMapping("/submit/valid")
	//bindingResult는 반드시 vo 객체 바로 뒤에 선언 되어야 한다. 
	public String submitValid(@Valid ValidVo validVo, 
						 BindingResult errors, 
						 Model model){
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidVoValidator());
	}
	
	
	
	
	
	
	
}
