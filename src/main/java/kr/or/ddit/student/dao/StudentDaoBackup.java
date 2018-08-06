package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("studentDao")
public class StudentDaoBackup implements StudentDaoInf {
	
//	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		
		List<StudentVo> studentList = template.selectList("student.selectAllStudents");
		return studentList;
	}

	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생 정보 조회 
	 */
	@Override
	public StudentVo getStudent(int id) {  // 단수 객체 반환 
		
		StudentVo studentvo = template.selectOne("student.getStudentById", id);
		return studentvo;
	}

	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 정보 조회 
	 */
	@Override
	public StudentVo getStudent(StudentVo studentVo) {
		
		StudentVo stVo = template.selectOne("student.getStudentByVo", studentVo);
		return stVo;
	}

	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 정보 페이지 리스트 조회  
	 */
	@Override
	public List<StudentVo> getStudentPageList( Map<String, Integer> map ) {
		
		List<StudentVo> studentList = template.selectList("student.getStudentPageList", map);
		return studentList;
	}

	/**
	 * 
	 * Method : getStudentTotalCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 학생 전체 건수 조회 
	 */
	@Override
	public int getStudentTotalCnt() {
		
		int totalCnt = template.selectOne("student.getStudentTotalCnt");
		return totalCnt;
	}

	/**
	 * 
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param studentVo
	 * @return  : 업데이트 건수 반환 
	 * Method 설명 : 학생정보 업데이트
	 */
	@Override
	public int studentUpdate(StudentVo studentVo) {
		
		int updateCnt = template.update("student.studentUpdate" , studentVo);
		return updateCnt;
	}

	


}
