package kr.or.ddit.student.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



//로그인 부터하려면~  localhost:8180/login/view
@RequestMapping("/student")				// url  : localhost:8180/student/list
@Controller("studentController")
public class StudentController {  		//  jsp프로젝트에서 작성한 - StudentServlet.java을 spring 으로 변경해보기
	
	@Resource(name="studentService")
	private StudentServiceInf studentService;
	
	// 요청 : student/list
	// 학생리스트 처리하는 메소드
	@RequestMapping("/list")
	public String studentList( @RequestParam(value="page", defaultValue="1") int page,  // 방법1 - 파라미터이용
							   @RequestParam(value="pageSize", defaultValue="10") int pageSize, 
							   Model model	){
//	public String studentList( @RequestParam Map<String, Integer> map,	Model model	){  // 방법2 - map이용
		
		
		// page, pageSize parameter 확인하기
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = studentService.getStudentPageList(paramMap);
//		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		model.addAllAttributes(resultMap); //자체를 통체로 전달 
		
//		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		return "student/list";
	}
	

	// 학생 상세 정보 조회   -- //  jsp프로젝트에서 작성한 - StudentDetailServlet.java을 spring 으로 변경해보기 - 간결해짐 
	@RequestMapping("/detail")
	public String detail(StudentVo vo, Model model){

		StudentVo studentVo = studentService.getStudent(vo);
		
		model.addAttribute("studentVo",studentVo);
		
		return "student/detail";
	}
	
//====tiles================================================================================================================================	
	/* 
	 * StudentController 
		메소드 추가 
		기존: /student/list (list.jsp) ,   /student/detail (detail.jsp) 
		
		추가 : /student/tiles/list   (tilesList.jsp)
			   /student/tiles/detail   (tilesDetail.jsp)

		( tiles-config.xml  studentList , studentDetail definition 추가 및  jsp	분리작업 진행  
		( top, left 는 /WEB-INF/views/tiles/top, left.jsp" 활용 )
	*/
	
		// 요청 : /student/tiles/list 
		// 학생리스트 처리하는 메소드
		@RequestMapping("/tiles/list")
		public String studentTilesList ( @RequestParam(value="page", defaultValue="1") int page,  // 방법1 - 파라미터이용
								   @RequestParam(value="pageSize", defaultValue="10") int pageSize, 
								   Model model	){

			Map<String, Integer> paramMap = new HashMap<String, Integer>();
			paramMap.put("page", page);
			paramMap.put("pageSize", pageSize);
			
			Map<String, Object> resultMap = studentService.getStudentPageList(paramMap);
			
			model.addAllAttributes(resultMap); //자체를 통체로 전달 
			
			return "studentList";
		}
	
	
		// 학생 상세 정보 조회   -- //  jsp프로젝트에서 작성한 - StudentDetailServlet.java을 spring 으로 변경해보기 - 간결해짐 
		@RequestMapping("/tiles/detail")
		public String studentTilesDetail (StudentVo vo, Model model){

			StudentVo studentVo = studentService.getStudent(vo);
			
			model.addAttribute("studentVo",studentVo);
			
			return "studentDetail";
		}
	
	
		
		//====json ================================================================================================================================	
		// 요청 : localhost:8180/student/list/json    
		// 학생리스트 처리하는 메소드
		@RequestMapping("/list/json")
		@ResponseBody
		public Map<String, Object> studentJsonList( @RequestParam(value="page", defaultValue="1") int page,  // 방법1 - 파라미터이용
								   @RequestParam(value="pageSize", defaultValue="10") int pageSize, 
								   Model model	){
	
			// page, pageSize parameter 확인하기
			Map<String, Integer> paramMap = new HashMap<String, Integer>();
			paramMap.put("page", page);
			paramMap.put("pageSize", pageSize);
			
			Map<String, Object> resultMap = studentService.getStudentPageList(paramMap);
//			Map<String, Object> resultMap = studentService.getStudentPageList(map);
				
//			RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
			return resultMap;
		}
		

		
		
	
	
	
	
	
}
