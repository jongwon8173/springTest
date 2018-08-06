package kr.or.ddit.ioc.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {

	
	// before annotation를 통해 스프링 ioc 컨테이너 생성
	private ApplicationContext context ;
	
	@Before
	public void setup(){
		// spring container 를 생성
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-collection.xml");
	}
	
	@Test
	public void listTest() {
		
		/***Given***/
		// spring ioc 컨테이너 생성(before)

		/***When***/
		// List 객체 getter 를 통해 
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		
		List cList = (List) collectionBean.getLists() ;

		for (Object nm : cList) {
			System.out.println(nm.toString());
		}
		System.out.println(cList.get(0));
		/***Then***/
		// List.get(0) == brown / List.get(1) == cony / List.get(2) == sally / List.get(3) == 한글 /
		
		assertEquals("brown", cList.get(0));
		assertEquals("cony", cList.get(1));
		assertEquals("sally", cList.get(2));
		assertEquals("한글", cList.get(3));

	}
	
	// spring container 정상 생성 확인
	@Test
	public void springContainterTest(){
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(context);
		assertTrue(context.getBeanDefinitionCount() >= 1);
		
	}
	
	@Test
	public void setTest() {
		
		/***Given***/
		// spring ioc 컨테이너 생성(before)

		/***When***/
		// List 객체 getter 를 통해 
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		
		Set set = (Set) collectionBean.getSets();
		Iterator setIt = set.iterator();
		
		/***Then***/
		assertEquals("한글", setIt.next().toString());
		assertEquals("sally", setIt.next().toString());
		assertEquals("cony", setIt.next().toString());
		assertEquals("brown", setIt.next().toString());
	}
	
	@Test
	public void mapTest() {
		
		/***Given***/
		// spring ioc 컨테이너 생성(before)

		/***When***/
		// List 객체 getter 를 통해 
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		
		Map map = (Map) collectionBean.getMap();
		
		/***Then***/
		assertEquals("sally", map.get("ranger1"));
		assertEquals("brown", map.get("ranger2"));
		assertEquals("cony", map.get("ranger3"));

	}
	
	@Test
	public void prosTest() {
		
		/***Given***/
		// spring ioc 컨테이너 생성(before)

		/***When***/
		// List 객체 getter 를 통해 
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Properties map = (Properties) collectionBean.getPros();

		/***Then***/
		assertEquals("brown", map.get("ranger1"));
		assertEquals("cony", map.get("ranger2"));
		assertEquals("sally", map.get("ranger3"));

	}

}
