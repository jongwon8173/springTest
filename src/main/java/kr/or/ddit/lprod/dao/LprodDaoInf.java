package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.student.model.StudentVo;

public interface LprodDaoInf {
	
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
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 상품대분류 페이지 리스트 조회 
	 */
	List<LprodVo> getLprodPageList(Map<String, Integer> map);
	
	
	/**
	 * 
	 * Method : getLprodTotalCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 상품대분류 전체 건수 조회
	 */
	int getLprodTotalCnt();


}
