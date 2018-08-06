package kr.or.ddit.ioc.javaconfig;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import javaconfig.JavaConfig;
import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
public class JavaconfingTest {

//	private ApplicationContext context;

	// iocDao, iocService
	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	@Resource(name="iocService")
	private IocServiceInf iocService;
	
	@Before
	public void setup(){
//		context = new AnnotationConfigApplicationContext(JavaConfig.class);
	}
	
	@Test
	public void javaConfigTest() {
		/***Given***/

		/***When***/
		// iocDao, iocService가 정상적으로 주입 되었는지 확인
		// 스프링 컨테이너에 DL --> @Resource(name="스프링빈")을 통해 주입
		String a = iocDao.hello();
		String b = iocService.hello();
		
		/***Then***/
		// iocDao.hello();			: "sayHello"
		// iocService.hello();		: "sayHello"
		// iocDao, iocService.getIocDao();
		assertEquals("sayHello", a);
		assertEquals("sayHello", b);

	}

}
