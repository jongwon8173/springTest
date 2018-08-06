package kr.or.ddit.ioc.placeholder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcInfoTest {

	private ApplicationContext context ;
	
	@Before
	public void setup(){
		// spring container 를 생성
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/apllication-placeholder.xml");
	}
	
	@Test
	public void jdbcTest() {
		
		/***Given***/
		// 스프링 컨테이너 생성

		/***When***/
		//jdbcInfo bean DL
		JdbcInfo jdbcInfo = (JdbcInfo) context.getBean("jdbcInfo");
//		System.out.println(jdbcInfo.getUrl());
//		System.out.println(jdbcInfo.getDriver());
//		System.out.println(jdbcInfo.getUsername());
//		System.out.println(jdbcInfo.getPassword());
		
		/***Then***/
		assertEquals("jdbc:oracle:thin:@localhost:1521:orcl", jdbcInfo.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", jdbcInfo.getDriver());
		assertEquals("java", jdbcInfo.getUsername());
		assertEquals("java", jdbcInfo.getPassword());
		

	}

}
