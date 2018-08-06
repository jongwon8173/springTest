package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodServiceInf {
	
	/**
	 * 
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 상품대분류 정보 조회
	 */
	List<LprodVo> selectAllLprod();
	
	/**
	 * 
	 * Method : getLprod
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param LprodVo
	 * @return
	 * Method 설명 : 전체 상품대분류 정보 조회
	 */
	LprodVo getLprod(LprodVo lprodVo);
	
	
	/**
	 * 
	 * Method : getLprodPageList
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 페이지수랑 페이지에 출력될 개수를 map으로 받아 , 다오의 2개메서드를 이용하여 받아온 값을 map으로 반환 
	 */
	Map<String, Object> getLprodPageList(Map<String, Integer> map);


	
	

}
