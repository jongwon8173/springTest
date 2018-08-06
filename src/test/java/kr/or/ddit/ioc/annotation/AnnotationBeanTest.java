package kr.or.ddit.ioc.annotation;

import static org.junit.Assert.*;
import kr.or.ddit.ioc.lifecycle.LifeCycleBean;
import kr.or.ddit.ioc.lifecycle.LifeCycleBeanTest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {

	
	private ApplicationContext context;
	private Logger logger = LoggerFactory.getLogger(LifeCycleBeanTest.class);
	
	// spring container 생성(before)
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-annotation.xml");
	}
	
	@Test
	public void test() {
		/***Given***/
		// spring container 생성
		
		/***When***/
		// annotationBean DL
		AnnotationBean annotationBean = context.getBean("annotationBean", AnnotationBean.class); 
		
		/***Then***/
		// name 속성 비교
		assertEquals("brown", annotationBean.getName());
	}

}
