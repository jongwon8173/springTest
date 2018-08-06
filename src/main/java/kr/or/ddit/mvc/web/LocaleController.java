package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/locale")
@Controller
public class LocaleController {
	
	// 국제화 코드를 담을 map을 생성하는 modelAttribute생성
	// jsp -> localeSelect.jsp 에서 했던것 응용, 뷰에 하드코딩했던것을 변경  
	// key : ko / value : 한국어     			<option value="ko">한국어</option>
	// key : en / value : 영어       			<option value="en">English</option>
	// key : ja / value : 일본어     			<option value="ja">日本の語</option>
	

	@ModelAttribute("localeMap")  // @ModelAttribute 에 설정한 이름으로 연결 뷰에서 해당이름의 객체로 값을꺼내 사용 
	public Map<String, String> localeMap(){
		Map<String, String> localeMap = new HashMap<String, String>();
		localeMap.put("ko", "한국어");
		localeMap.put("en", "English");
		localeMap.put("ja", "日本の語");
		
		return localeMap;
	}

	
	// localhost:8180/locale/view 로 호출시 
	@RequestMapping("/view")
	public String view(){
		
		return "locale/view";
	}
	
	/*
	 * 어떤 viewResolver에서 처리될지를 결정 : servlet-context.xml에 설정한 view resolver의 우선순의에 따라 결정 
	 * 
	 * 우리가 설정한 상황 
	 * BeanNameViewResolver 		: property: 1
	 * TilesViewResolver			: property: 2
	 * InternalResourceViewResolver : property: 3
	 * 
	 * view 이름으로 "locale/view" 을 controller에서 리턴한 경우 
	 * 
	 * 1. beanNameViewReaolver에 의해 스프링 빈중 이름이 "locale/view"을 갖는 view가  등록되었는지 확인 
	 * --> bean이 존재하지 않음  --> 다음 viewResolver로 이동 
	 * ** "jsonView", "excelDownloadView", "fileDownloadView"
	 * 
	 * 2. TilesViewResolver를 통해 tile-config.xml 에 설정된 definitions name중 "locale/view"와 일치하는 definitions이 존재하는지 확인 
	 * --> name 일치하는 definitions이 존재하지 않은 --> 다음  viewResolver로 이동 
	 * 
	 * 3. InternalResourceViewResolver
	 * InternalResourceViewResolver 는 해당 리소스가 존재하는지 여부 확인하지 않고 
	 * prefix + viewName + surfix로 forward 처리함 
	 * --> viewName에 해당하는 리소스가 없을 경우 404에러 
	 * 
	 */
}
