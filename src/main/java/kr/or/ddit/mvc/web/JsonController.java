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

import com.sun.tracing.dtrace.ModuleAttributes;

@RequestMapping("/json")
@Controller
public class JsonController { 
	
	@ModelAttribute("rangers")  // 가 먼저 실행 되고 @RequestMapping 이 실행됨 
	public void rangers( Model model){
		
		List<String> list = new ArrayList<String>();
		list.add("brown");
		list.add("cony");
		list.add("sally");
		
		model.addAttribute("rangers", list);  // model을 사용하면 리턴까지 해주므로 리턴 타입이 없어도 됨 
		
	}
	

	
	
	// rangers 리스트를 json 응답으로 생성  
	// localhost:8180/json/data
	@RequestMapping("/data") 
	public String data(){
		
		return "jsonView";   // servlet-context.xml 에 지정한 id 
		// 지금까지controller는 view이름 jsp를 리턴 (폴더를 포함한 경와 jsp파일이름을 리턴했음 )
		// 현재 viewResolver 설정상황 
		// 1. 두개의 viewResolver가 등록되있음
		// 		1.1 name=order 0 : BeanNameViewResolver   - 먼저 실행
		// 		1.2 name=order 1 : InternalResourceViewResolver
		
		/*
		 * return "jsonView"; // servlet-context.xml 에 지정한 id로 리턴 , 
		 * <bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView" > </bean>  : json 을 만들고 
		
		 * <!-- bean name view resolver   -->
			<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">    출력도해줌 
			<property name="order" value="0"></property>
			</bean>
		 
		 */
	}
	
	// Spring을 이용한 AJAX 처리
	// rangers 리스트를 json 응답으로 생성을 하는데 (@ResponseBody 이용)
	// localhost:8180/json/data/responseBody 
	@RequestMapping("/data/responseBody")
	@ResponseBody
	public List<String> dataResponseBody(Model model){
		List<String> rangers = (List<String>) model.asMap().get("rangers");
		return rangers;
	}
	
	//localhost:8180/json/requestView
	// json 요청 테스트를 위한 view
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
		  rangers.set( i, rangers.get(i) + "_requestBody" + UUID.randomUUID().toString()   );
		}
		return rangers;   // 클라이언트가 url을 통해 제이슨 형태로 요청을 보낼거고, 제이슨 문자열을 해석을해서 리스트형태로 만들어준다. 루트를 돌면서 각 문자열에 "_requestBody"을 붙여주고,	@ResponseBody   응답을 json으로 보낸다 
	}
	
	


/*

	@RequestMapping(value = "/test/simpleTest.do")
	public String simpleTestForm() {

		return "test/simpleTestForm";

	}

	@RequestMapping()
	// @RequestBody 어노테이션은 @RequestMapping에 의해 POST 방식으로 전송된 HTTP 요청 데이터를 String
	// 타입의 body 파라미터로 전달된다.(수신)
	// 그리고 @ResponseBody 어노테이션이 @RequestMapping 메서드에서 적용되면 해당 메서드의 리턴 값을 HTTP 응답
	// 데이터로 사용한다.
	// simpleTest() 메서드의 리턴 값이 String 타입이므로 String 데이터를 HTTP 응답 데이터로 전송한다.(송신)
	@ResponseBody
	public String simpleTest(@RequestBody String body) {

		return body;

	}


*/
	/*
	- 학생 리스트랑, 네비게이션 을 json응답으로 처리하기 
	
	
	*/
	
	
	
	
	
	// localhost:8180/json/excelData
	@RequestMapping("/excelData")
	public String excelData(){
		
		return "excelDownloadView";
	}
	
	
	// localhost:8180/json/fileDown?fileName=sally.png
	// localhost:8180/json/fileDown?fileName=89afbd4a-e437-4cdb-92ae-71923bf96db8.png  으로 요청을 보내면,
	// bean에 설정해놓은 	<bean id="fileDownloadView" class="kr.or.ddit.mvc.view.FileDownloadView"></bean> 곳으로 가고 FileDownloadView" 를 타면서 다운로드되는 방식 
	@RequestMapping("fileDown")
	public String fileDown(@RequestParam("fileName") String fileName, Model model){
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
