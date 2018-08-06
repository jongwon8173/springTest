package kr.or.ddit.login.web;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.mvc.web.HelloController;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml", 
								 "classpath:kr/or/ddit/config/spring/servlet-context.xml" })

@WebAppConfiguration
public class LoginControllerTest {
	
	private Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	
	 
	@Resource(name="loginController")
	private LoginController loginController;
	
	@Test
	public void helloControllerInitTest() {
		assertNotNull(loginController);
	}
	
	
//	@Test
//	public void LoginControllerViewTest() {
//		fail("Not yet implemented");
//	}

}
