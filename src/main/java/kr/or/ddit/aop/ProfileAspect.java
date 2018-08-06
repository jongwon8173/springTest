package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 메소드 실행 전 후 시간을 측정할 aspect 
// 메소드 실행 로그 
public class ProfileAspect {

	private Logger logger = LoggerFactory.getLogger(ProfileAspect.class);

	// 메소드 실행전 로그 작성 
	public void beforeMethod(JoinPoint point){
		
		// 메소드 실행전 로그 작성 
		String className = point.getTarget().getClass().getSimpleName();   // 클래스의 정보를 가져오는 
		String methodName = point.getSignature().getName();  // method 이름을 확인할수 잇는 
		logger.info("beforeMethod, className : {} , methodName : {}" , className ,  methodName );
	}
	
	// 메소드 실행전 로그 작성 
	
	public void afterMethod(JoinPoint point){	// joinpoint 는 method 자체를 의미
		
		// 메소드 실행전 로그 작성 
		String className = point.getTarget().getClass().getSimpleName();   // 클래스의 정보를 가져오는 
		String methodName = point.getSignature().getName();  // method 이름을 확인할수 잇는 
		logger.info("afterMethod, className : {} , methodName : {}" , className ,  methodName );
	}
	
	// 메서드 실행 전호(around)
	public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
		String className = point.getTarget().getClass().getSimpleName();   // 클래스의 정보를 가져오는 
		String methodName = point.getSignature().getName();  // method 이름을 확인할수 잇는
		// 메소드 실행전
		long startTime = System.currentTimeMillis();

		// 메소드 실행(실행에 필요한 메소드 인자, 리턴값)
		// 메소드인자 구하기
		Object[] args = point.getArgs();
		
		// 메소드 실행하기
		Object ret = point.proceed(args);
		
		// 메소드 실행후
		long endTime = System.currentTimeMillis();
		
		// 메소드 profiling 
		logger.debug("arounMethod profiling : {} ms {}, {}", endTime - startTime, methodName, className);
		
		return ret;
	}
	
}
