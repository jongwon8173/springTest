package kr.or.ddit.lprod.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
/*
 *  spring controller test 설정
 *  
 *  1. Spring을 JUnit에서 사용할 수 있도록 설정 : @RunWith(SpringJUnit4ClassRunner.class)
 *  2. Spring 설정 파일 설정 : @ContextConfiguration(locations={ })
 *  3. Spring container가 웹 어플리케이션 컨텍스트로 생성될 수 있도록 : @WebAppConfiguration
 *  
 *  4. 스프링 웹환경과 동일하게 요청을 할수 있도록 dispatcherServlet역할을 하는 MockMvc 객체생성
 *  		--> MockMvc를 설정하기 위해서는 WebApplicationContext 객체가 필요
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml"
		, "classpath:kr/or/ddit/config/spring/servlet-context.xml" })
@WebAppConfiguration
public class LprodControllerTest {
	
	@Resource  //@Autowired //  WebApplicationContext 객체
	private WebApplicationContext context;
	 
	private MockMvc mockMvc;  // dispatcherServlet역할
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	// 상품lprod 리스트 페이징 조회 테스트 --
	@Test
	public void lprodListTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform( get("/lprod/lprodList").param("page", "1").param("pageSize", "10")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		List<LprodVo> lprodList = (List<LprodVo>) mav.getModel().get("lprodList");

		/***Then***/
		assertEquals("lprod/lprodList", mav.getViewName());
		
		assertEquals( 9, lprodList.size());
		assertTrue( (Integer)mav.getModel().get("totalCnt") > 10 );
		assertNotNull(mav.getModel().get("pageNavi"));

	}

}
