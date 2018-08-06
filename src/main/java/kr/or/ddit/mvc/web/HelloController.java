package kr.or.ddit.mvc.web;

import javax.annotation.Resource;

import kr.or.ddit.ioc.service.IocServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")  //클래스명 어노테이션 localhost:8180/hello/view 
@Controller   
public class HelloController {
	
	@Resource(name="iocAnnotationService")
	private IocServiceInf iocService;
	
	// return : view 이름
	// localhost:8180/hello/view
	// localhost:8180/view : 클래스 어노테이션이 없다면
	@RequestMapping("/view") // 메소드명 어노테이션
	public String hello(Model model){
		
		// BoardServiceInfo boardSrvice = new BoardService();
		// hello()메소드의 리턴값을 hello.jsp애서 출력 
		String msg = iocService.hello();
		model.addAttribute("msg", msg);
		
		// default : forward (기본은 forward)
		// redirect: hello
		return "hello";
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// --> /WEB-INF/views/hello.jsp
	}// hello() end
}
