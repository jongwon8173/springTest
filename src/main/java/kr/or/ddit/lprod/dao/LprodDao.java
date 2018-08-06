package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LprodDao implements LprodDaoInf {
	
	private SqlSessionFactory sqlsessionFactory = SqlMapSessionFactory.getSqlSessionFactory(); 
	
	/**
	 * 
	 * Method : selectAllLprod
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 상품대분류 정보 조회
	 */
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlsessionFactory.openSession();
		
		List<LprodVo> lprodList = session.selectList("lprodxml.selectAllLprod");
		session.close();
		
		return lprodList;
	}
	

	@Override
	public LprodVo getLprod(LprodVo lprodVo) {
		SqlSession session = sqlsessionFactory.openSession();
		LprodVo lprodvo = session.selectOne("lprodxml.getLprod", lprodVo);
		session.close();
		return lprodvo;
	}
	
	
	/**
	 * 
	 * Method : getLprodPageList
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 상품분류 페이지 리스트 조회  / 페이지개수 , 페이지 사이즈, 한페이지에 출력되는 정보를 받아서 해당하는 리스트 조회해서 반환 
	 */
	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlsessionFactory.openSession();
		
		List<LprodVo> lprodList = session.selectList("lprodxml.getLprodPageList", map);
		session.close();
		return lprodList;
	}

	
	/**
	 * 
	 * Method : getLprodTotalCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 상품분류 전체 개수 조회
	 */
	@Override
	public int getLprodTotalCnt() {
		SqlSession session = sqlsessionFactory.openSession();
		
		int lprodCnt = session.selectOne("lprodxml.getLprodTotalCnt");
		return lprodCnt;
	}


}
