package kr.or.ddit.student.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 *  2. Spring 설정 파일 설정 : @ContextConfiguration
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
public class StudentControllerTest {
	
//	@Autowired
	@Resource
	private WebApplicationContext context;
	
	// mockMvc
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	
	// 학생 리스트 페이징 조회 테스트
	@Test
	public void studentListTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform( get("/student/list")
										.param("page", "1")
										.param("pageSize", "10") ).andReturn();  // perform통해 요청보냄 // .andReturn() 결과를 보내고 받는녀석

		/***When***/

		/***Then***/
		// viewName  : (student/list)
		// 속성들을 테스트 : Map객체에 보낸녀석들 (studentList, totCnt, pageNavi) 테스트하기
		
		ModelAndView mav = result.getModelAndView();
//		mav.getViewName();
//		mav.getModel().get("studentList");
		assertEquals("student/list", mav.getViewName());
		
		List<StudentVo> studentList = (List<StudentVo>) mav.getModel().get("studentList"); 
		
		assertEquals( 10, studentList.size() );
		assertTrue( (Integer)mav.getModel().get("totCnt") > 10 );
		assertNotNull( mav.getModel().get("pageNavi") );
	}

	
	
	// "/student/detail"  url을 테스트
	@Test
	public void detailTest() throws Exception{
		/***Given***/
		MvcResult result = mvc.perform(get("/student/detail").param("id", "2")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		StudentVo studentVo = (StudentVo) mav.getModel().get("studentVo");

		/***Then***/
		assertNotNull(studentVo);
		assertEquals(2, studentVo.getId());
		assertEquals("강병관 ", studentVo.getName());
		assertEquals("34940", studentVo.getZipcd());

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
