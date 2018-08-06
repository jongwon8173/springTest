package kr.or.ddit.student.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

public interface StudentServiceInf {
//	이전시간에 했던 studentDao  다음에 
//	studentService (패키지,  인터페이스 , 구현체, 테스트 코드  )만들기 
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	List<StudentVo> selectAllStudents();
	
	

	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생정보 조회  / 특정학생 정보조회 , 학생 id를 받아 학생정보를 조회한다.
	 */
	StudentVo getStudent(int id);
	
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생정보 조회  / 특정학생 정보조회 , 학생 studentVo를 받아 학생정보를 조회한다.
	 */
	StudentVo getStudent(StudentVo studentVo);
	
	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회 
	 */
	Map<String, Object> getStudentPageList(Map<String, Integer> map);
	
	
	
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
	int studentUpdate(StudentVo studentVo);

}
