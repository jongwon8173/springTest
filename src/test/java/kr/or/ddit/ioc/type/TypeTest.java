package kr.or.ddit.ioc.type;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// spring 환경에서 junti 구동
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/ioc/application-type.xml"})
public class TypeTest {
	
	// iocVo
//	@Resource(name="iocVo")
//	private IocVo iocVo;
	
	//iocFormattingVo
	@Resource(name="iocFormattingVo")
	private IocFormattionVo iocFormattingVo;
	
	@Test
	public void iocFormattingVoTest() {
		
		/***Given***/

		/***When***/

		/***Then***/
		// name, regDt(yyyy-MM-dd), modDt(MM-dd-yyyy)
		
		assertEquals("brown", iocFormattingVo.getName());
		assertEquals("2018-07-30", new SimpleDateFormat("yyyy-MM-dd").format(iocFormattingVo.getRegDt()));
		assertEquals("07-30-2018", new SimpleDateFormat("MM-dd-yyyy").format(iocFormattingVo.getModDt()));
		assertEquals(9999123, iocFormattingVo.getAmount());
	}
	 
	
//	@Test
//	public void iocVoTest() {
//		/***Given***/
//
//		/***When***/
//
//		/***Then***/
//		// 설정 파일(application-type.xml)에서 주입한 속성(name, regDt)가 정상적으로
//		// 주입되었는지 확인
//		assertEquals("brown", iocVo.getName());
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		
//		// xml 에서 Data 가 변환이 안됨..!! ∴ 아래와 같은 방식..
//		assertEquals("2018-07-30", sdf.format(iocVo.getRegDt()));
//		
//	}
//	
////	@Test
//	public void iocVoSettetTest(){
//		
//		/***Given***/
//
//		/***When***/
//		assertEquals("brown", iocVo.getName());
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		// xml 에서 Data 가 변환이 안됨..!! ∴ 아래와 같은 방식..
//		assertEquals("2018-07-30", sdf.format(iocVo.getRegDt()));
//
//		
//	}
}
