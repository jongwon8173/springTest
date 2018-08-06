package kr.or.ddit.login.web;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	private Logger logger  = LoggerFactory.getLogger(LoginController.class);
	
	// 시작 url : localhoast:8180/login/view
	@RequestMapping("/view")
	public String login(Model model){
		
		return "login/login";
	}
	
	
	
	// model 객체 => 컨트롤러에서 뷰로 전환할 때 데이터를 가지고 있는 객체, 컨트롤러가 뷰로 model 객체를 넘겨 뷰에서 model 객체의 데이터 이용 가능
	//출처: http://lopicit.tistory.com/224 [로픽의 IT블로그]
	
	// 로그인처리   (login.jsp 에서 form액션에 action="loginProcess")
	//@RequestMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request){
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		// logger : userId, password 를 찎어보자 
		logger.debug("{}" , userId + " : " + password);
		// 정상접속 완료
		
		//  /WEB-INF/view/   mian.jsp
		return "main";
	}
	
	
	
	
	// 로그인처리   (login.jsp 에서 form액션에 action="login/loginProcess")
	//@RequestMapping("/loginProcess")
	public String loginProcess(UserVo userVo){
		
		// logger : userId, password 를 찎어보자 
		logger.debug("{}", userVo.getUserId() + " : " + userVo.getPassword() );
		
		// 정상접속 완료
		
		//  /WEB-INF/view/
		return "main";
		
		
	}
	
	// 로그인처리   (login.jsp 에서 form액션에 action="login/loginProcess")
		@RequestMapping("/loginProcess")
		public ModelAndView loginProcess2(UserVo userVo){
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("main");   // = return "main";  =  /WEB-INF/view/mian.jsp
			
			mav.addObject("from", "modleAndView");   // main.jsp에서  ${from }  하면 modleAndView 출력  (2018.07.02, room 207 modleAndView)
			
			// logger : userId, password 를 찎어보자 
			logger.debug("{}", "return ModleAndView" );
			logger.debug("{}", userVo.getUserId() + " : " + userVo.getPassword() );
			
			// 정상접속 완료
			
			return mav;
		}
		
	
		
		

}
