package kr.or.ddit.aop.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml"
								,"classpath:kr/or/ddit/config/spring/datasource.xml"
								,"classpath:kr/or/ddit/config/spring/transaction.xml"
								})
public class TempDaoTest {

	@Resource(name="tempDao")
	private TempDaoInf tempDao;
	
	Logger logger = LoggerFactory.getLogger(TempDaoTest.class);
	
	
	// tempDao 빈 확인 테스트
	@Test
	public void test() {

		/***Given***/
		

		/***When***/

		/***Then***/

		assertNotNull(tempDao);
		
	}
	// getAllStudent 테스트
	@Test
	public void getAllStudentTest(){
		/***Given***/
		
		/***When***/
		List studentList= (List<Map<String, String>>)tempDao.getAllStrudent();
		
		/***Then***/
		assertEquals(25, studentList.size());

	}
	
	// insertStudent 테스트
	@Test
	public void insertStudentTest(){
		
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("id","99");
		map.put("name","brown");
		map.put("call_cnt", "0");

		/***When***/

		int insertCnt = tempDao.insertStudnet(map);
		
		/***Then***/
		assertEquals(1, insertCnt);

		
	}
	

}
