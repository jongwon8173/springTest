package kr.or.ddit.mvc.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml", 
								 "classpath:kr/or/ddit/config/spring/servlet-context.xml" })

@WebAppConfiguration  // applicationContext 객체를 webAppilcationContext 를 사용하도록 설정
public class HelloControllerTest {
	
	private Logger logger = LoggerFactory.getLogger( HelloControllerTest.class );
	
	// 스프링 모든 요청은 dispatcherServlet이 처리
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;  // dispatcher servlet
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	// helloController spring 빈Bean을 주입 받을 수 있다 
	@Resource(name="helloController")
	private HelloController helloController;
	
	
	
	@Test
	public void helloControllerInitTest() {
		assertNotNull(helloController);
	}
	
	// hello.jsp 요청 테스트 
	@Test
	public void helloControllerViewTest() throws Exception{
		// url로 요청(httpMethod : get / post)
		MvcResult mvcResult = mockMvc.perform( get("/hello/view") ).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		assertEquals("hello", viewName);
		logger.debug("{}", "viewName : " + viewName);
		
		// model msg
		Map<String, Object> model = mav.getModel();
		String msg = (String) model.get("msg");
		assertEquals("sayHello", msg);
		logger.debug("{}", "msg : " + msg);
		
//		12:35:42.024 [main] DEBUG kr.or.ddit.mvc.web.HelloControllerTest - viewName : hello
//		12:35:42.026 [main] DEBUG kr.or.ddit.mvc.web.HelloControllerTest - msg : sayHello
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
