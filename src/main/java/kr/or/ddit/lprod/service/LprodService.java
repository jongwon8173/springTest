package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

@Service("lprodService")  // controller 에 매핑한 서비스이름과 같아야한다. 
public class LprodService implements LprodServiceInf {

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
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.selectAllLprod();
	}
	
	
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
	@Override
	public LprodVo getLprod(LprodVo lprodVo) {
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.getLprod(lprodVo);
	}


	/**
	 * 
	 * Method : getLprodPageList
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 상품정보 페이지 리스트 조회랑& 상품 전체건수 조회 07.11
	 */
	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> map) {
		
		LprodDaoInf lprodDao = new LprodDao();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<LprodVo> lprodList = lprodDao.getLprodPageList(map);
		resultMap.put("lprodList", lprodList);
		
		int totalCnt = lprodDao.getLprodTotalCnt();
		resultMap.put("totalCnt", totalCnt);
		
		int page = map.get("page");     // serVlet에서 put한거 가져온거 
		int pageSize = map.get("pageSize");
		
		/*
		// 해당부분을 메서드로 따로 뺌 makePageNavi()
		*/
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totalCnt ));
		
		return resultMap;
	}

	/**
	 * 
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totalCnt
	 * @return
	 * Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totalCnt) {
		int cnt = totalCnt / pageSize; // 몫
		int mod = totalCnt % pageSize; // 나머지 
		
		if( mod > 0 )
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1; 
		int nextPage = page == cnt ? page : page + 1;
		
		pageNaviStr.append("<li> <a href=\"/lprod/lprodList?page=" + prevPage + "&pageSize=" + pageSize+ "\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span> </a> </li>");  //<<부트 스트랩에서 페이지네이션부분 복사해오기 
	    
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";

			if( i == page )
				activeClass = "class=\"active\"";  //if문 end
			//http://localhost:8180 /studentList?page=3&pageSize=10 ↘링크 적용해주기
			pageNaviStr.append("<li " + activeClass + "><a href=\"/lprod/lprodList?page=" + i + "&pageSize=" + pageSize+ "\">" + i + "</a></li>");
		}
		
		pageNaviStr.append("<li> <a href=\"/lprod/lprodList?page=" + nextPage + "&pageSize=" + pageSize+ "\" aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span> </a> </li>"); // >>
		
		
		return pageNaviStr.toString();
	}
	
	
	
}
