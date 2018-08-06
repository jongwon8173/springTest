package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Test;

public class LprodServiceTest {

	/**
	 * 
	 * Method : test
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * Method 설명 : 전체 상품대분류 정보 조회 테스트 / 서비스
	 */
	@Test
	public void selectAllLprodTest() {
		/***Given***/
		LprodServiceInf lprodServise = new LprodService();

		/***When***/
		List<LprodVo> lprodList = lprodServise.selectAllLprod();

		/***Then***/
		assertEquals(9, lprodList.size());

	}

}
