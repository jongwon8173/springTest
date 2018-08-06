package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;


//@Repository("studentDao")
public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
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
		SqlSession session = sqlSessionFactory.openSession();  // 메소드 호출할 떄 그떄그떄 실행되야하기떄문에 sessin객체를 공유해서 사용하는 것은 잘못된것이다. 
		
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
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
		SqlSession session = sqlSessionFactory.openSession();
		
		StudentVo studentvo = session.selectOne("student.getStudentById", id);
		session.close();
		
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
		SqlSession session = sqlSessionFactory.openSession();
		
		StudentVo stVo = session.selectOne("student.getStudentByVo", studentVo);
		session.close();
		
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
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", map);
		session.close();
		
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
		SqlSession session = sqlSessionFactory.openSession();
		int totalCnt = session.selectOne("student.getStudentTotalCnt");
		
		session.close();
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
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("student.studentUpdate" , studentVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}

	


}
