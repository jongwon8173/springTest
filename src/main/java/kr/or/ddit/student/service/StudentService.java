package kr.or.ddit.student.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.springframework.stereotype.Service;


@Service("studentService") // // controller 에 매핑한 서비스이름과 같아야한다. @Resource(name="studentService")
public class StudentService implements StudentServiceInf {
	
	@Resource(name="studentDao")
	private StudentDaoInf studentDao;
	
	//StudentDaoInf studentDao = new StudentDao();
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 09.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 학생정보 전체 조회 
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		//StudentDaoInf studentDao = new StudentDao();
		return studentDao.selectAllStudents();
	}

	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생정보 조회 
	 */
	@Override
	public StudentVo getStudent(int id) {
		//StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(id);
	}
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생정보 조회 
	 */
	@Override
	public StudentVo getStudent(StudentVo studentVo) {
		//StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(studentVo);
	}


	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 정보 페이지 리스트 조회랑& 학생 전체건수 조회 07.11
	 */
	@Override
	public Map<String, Object> getStudentPageList( Map<String, Integer> map ) {
		//StudentDaoInf studentDao = new StudentDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 학생 페이지 리스트 조회
		List<StudentVo> studentList = studentDao.getStudentPageList(map);
		resultMap.put("studentList", studentList);
		
		// 학생 전체 건수 조회
		int totCnt = studentDao.getStudentTotalCnt();
		resultMap.put("totCnt", totCnt);
		
		
		// 페이지 네비게이션 html 생성 
		int page = map.get("page");     // serVlet에서 put한거 가져온거 
		int pageSize = map.get("pageSize");
		
		/*
		// 해당부분을 메서드로 따로 뺌 makePageNavi()
		*/
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt ));
		
		return resultMap;
	}
	
	/**
	 * 
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return
	 * Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지 
		
		if( mod > 0 )
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page - 1; 
		int nextPage = page == cnt ? page : page + 1;
		
	      pageNaviStr.append("<li data-page=\"" + prevPage+"\" data-pageSize=\""+pageSize+"\"><a href=\"/student/list?page="+prevPage+
	              "&pageSize="+pageSize+"\" aria-label=\"Previous\">"
	              + "<span aria-hidden=\"true\">&laquo;</span></a></li>");

	      		//"<li data-page="10" data-pageSize="10"><a href="/student/tiles/list?page=10&pageSize=10" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li><li data-page="1" data-pageSize="10"><a href="/student/tiles/list?page=1&pageSize=10">1</a></li><li data-page="2" data-pageSize="10"><a href="/student/tiles/list?page=2&pageSize=10">2</a></li><li data-page="3" data-pageSize="10"><a href="/student/tiles/list?page=3&pageSize=10">3</a></li><li data-page="12" data-pageSize="10"><a href="/student/tiles/list?page=12&pageSize=10"aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>"  
	     
	        for(int i=1; i<=cnt; i++){
	           String activeClass = "";
	           if (i==page) 
	              activeClass = "class=\"active\"";

	           pageNaviStr.append("<li data-page=\""+i+"\" data-pageSize=\""+pageSize+"\""+activeClass+"><a href=\"/student/list?page="+i+
	                              "&pageSize="+pageSize+"\">"+i+"</a></li>");
	        }   
	        
	        
	        pageNaviStr.append("<li data-page=\""+nextPage+"\" data-pageSize=\""+pageSize+"\"><a href=\"/student/list?page="+nextPage+
	              "&pageSize="+pageSize+ "\"aria-label=\"Next\">"
	              + "<span aria-hidden=\"true\">&raquo;</span></a></li>");
	        
	        return pageNaviStr.toString();
	}

	
	/**
	 * 
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 정보 업데이트 
	 */
	@Override
	public int studentUpdate(StudentVo studentVo) {
		//StudentDaoInf studentDao = new StudentDao();
	
		return studentDao.studentUpdate(studentVo);
	}

	
	
	
	
	
	
}
