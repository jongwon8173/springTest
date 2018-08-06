package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@ControllerAdvice    // 를 사용하기위해 scan처리 
/*<!-- controller scan  -->
<context:annotation-config/>
<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
	<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
</context:component-scan>*/

public class ExceptionAdvice {    // @ControllerAdvice 를 사용한 예외처리 - 잘안씀 
	
	@ExceptionHandler({ArithmeticException.class})
	public String handleException(Throwable e, HttpServletResponse response){
		
		return "error/arith";
	}

}
