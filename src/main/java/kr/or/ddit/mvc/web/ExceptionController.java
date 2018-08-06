package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/exceptionController")
@Controller
public class ExceptionController {  // 예외를 강제로 발생시켜 처리하는방법 - 잘사용하지 않는 방법
	
//	url : localhost:8180/exceptionController/exception
	
	@RequestMapping("/exception")
	public String exceptionTest(){
		
		// 예외 강제로 발생
		throw new ArithmeticException();
		
//		return "mvc/hello";
	}

//	@ExceptionHandler({ArithmeticException.class})     							// ExceptionAdvice.java를 사용하기위해 잠깐 주석처리
//	public String handleException(Throwable e, HttpServletResponse response){
//		
//		return "error/arith";
//	}
	
	
	//===================================================================================================
	
	// noFileException(@ResponseStatus)
//	url : localhost:8180/exceptionController/noFileException
	@RequestMapping("/noFileException")
	public String noFileException() throws NoFileException{
		
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			throw new NoFileException(); 
		}
		
//		return "mvc/hello";
	}
	
	
}
