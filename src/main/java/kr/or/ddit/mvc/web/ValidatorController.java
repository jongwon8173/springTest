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
	
//	url : localhost:8180/valid/view
	
	@RequestMapping("/view")
	public String view(){
		return "mvc/valid/view";
	}
	
	//______________________________________________________________________________________________________________
	
	//■ spring validate 사용를 사용하여 호출하는 방법, validate 호출해서 사용해야함 (밸리데이터를 직접 만들어 사용하는 방법으로 개발자가 많이 사용하는 방법)
	// <artifactId>validation-api</artifactId> 라이브러리 사용하기위한 메소드
	@RequestMapping("/submit")
	// bindingResult 는 vo 객체 바로뒤에 선언되어야 한다. ★ 아니면 동작을 안함 
	public String submit( ValidVo validVo,  BindingResult errors, Model model ){
		
		new ValidVoValidator().validate(validVo, errors); // 스프링 제공하는 validate사용
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	//______________________________________________________________________________________________________________
	//■ jsr303  // @Valid 어노테이션 사용하여 호출하는 방법 (어노테이션에서 제공해주는것만 사용가능하여 고정적이다.)
	// hibernate-validator 라이브러리를 사용하기위한 메소드
	@RequestMapping("/submit/jsr303") 
	public String jsr303Vo( @Valid ValidJsr303Vo validJsr303Vo,  BindingResult errors, Model model ){
		
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validJsr303Vo", validJsr303Vo);
		
		return  "mvc/valid/view";
	}
	
	//______________________________________________________________________________________________________________
	
	//■ initBind 사용(initBinder() 메소드를 별도로 만들어서 사용) ( spring Validator + jsr303 @Valid ) : validate 호출없이 자동실행 
	@RequestMapping("/submit/valid")
	// bindingResult 는 vo 객체 바로뒤에 선언되어야 한다. ★ 아니면 동작을 안함 
	public String submitValid( @Valid ValidVo validVo,  BindingResult errors, Model model ){
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	@InitBinder  // 컨트롤러(vo) 당 하나만 사용가능하여 일반적으로 잘사용하지 않는다 .
	public void initBinder(WebDataBinder binder){
		binder.setValidator(new ValidVoValidator());
	}
	
	
	
	
	
	
	
	
}
