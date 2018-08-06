package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import kr.or.ddit.util.FileUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@SessionAttributes("boardList")
@RequestMapping("/mvc")
@Controller("mvcController")
public class MvcController {
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	
	// @ModelAttribute 테스트
	@ModelAttribute("boardList")
	public List<String> boardList(){
		logger.debug("{}", "boardList");
		
		//db에서 조회한 보드 리스트라고 가정
		List<String> boardList = new ArrayList<String>();
		boardList.add("자유게시판");
		boardList.add("Q&A");
		boardList.add("공지사항");
		
		return boardList;
	}
	

	// localhost:8180/mvc/view   - 요청되도록 jsp파일을 해당위치에 개발할 수 있어야한다. 
	// mvc 어노테이션을 테스트할 view
	@RequestMapping(value="/view", method=RequestMethod.GET) // post요청을 보냈는데 , GET만 받을 수 있도록 설정 해보자, 오류 ==> message Request method 'POST' not supported
	public String view(){
		
		return "mvc/view";
	}
	
	@RequestMapping(value="/view2", method=RequestMethod.GET) // post요청을 보냈는데 , GET만 받을 수 있도록 설정 해보자, 오류 ==> message Request method 'POST' not supported
	public String view2(HttpSession session){
		
		return "mvc/view2";
	}
	
	
	
	// @RequestParam : 특정 이름의 파라미터를 메소드 인자에서 받을 수 잇다 
	@RequestMapping(value="/requestParam", method=RequestMethod.GET)   
	public String requestParam( @RequestParam("userId") String param ){
		
		logger.debug("{}", "param : " +  param);   // param : brown
		
		return "mvc/view";
	}
	
	
	
	
	// url: localhost:8180/mvc/pathVariable/35
//	@PathVariable  test
	@RequestMapping(value="/pathVariable/{boardNum}")  //  
	public String pathVariable(@PathVariable("boardNum") String boardNum, Model model ){
		model.addAttribute("boardNum", boardNum);
		
		
		return "mvc/view";
	}
	
	
	
	// url: localhost:8180/mvc/multipart/view
	// multipart test용 view 
	@RequestMapping("/multipart/view")
	public String multipartView(){
		
		return "mvc/multipartView";
	}
	
	
	// multipart upload 처리  -=-  사용하려면 pom & servlet-context.xmml에 추가 
	@RequestMapping("/multipart/upload")
	public String multipartUpload(@RequestParam("userId")String userId
								, @RequestPart("uploadFile")MultipartFile file 
//								, @RequestPart("files")MultipartFile[] files 
								, FileVo files
								, MultipartHttpServletRequest request
								, Model model){ 
		
		
		for (MultipartFile f : files.getFiles()) {
			logger.debug("{}", "f.getOriginalFilename()  : " + f.getOriginalFilename());
		}
		
		// jsp에서 가져온값 찍어보기 
		// userId : text
		// uploadFile : file 
		logger.debug("{}", "userId  : " + userId);
		model.addAttribute("userId" , userId);
		
		file.getName();
		logger.debug("{}", "file.getName() : " + file.getName());
		
		file.getOriginalFilename();
		logger.debug("{}", "file.getOriginalFilename() : " + file.getOriginalFilename());
		
		/* 로그결과 
		14:38:09.777 [http-bio-8180-exec-23] DEBUG kr.or.ddit.mvc.web.MvcController - userId  : brown
		14:38:09.778 [http-bio-8180-exec-23] DEBUG kr.or.ddit.mvc.web.MvcController - file.getName() : uploadFile
		14:38:09.779 [http-bio-8180-exec-23] DEBUG kr.or.ddit.mvc.web.MvcController - file.getOriginalFilename() : 3863720.png
		*/
		String path = FileUtil.fileUploadPath;
		String fileName = UUID.randomUUID().toString();
		File uploadFile = new File(path + File.separator + fileName);
		
		try {
			
			file.transferTo(uploadFile);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		logger.debug("{}", "userId :  " + request.getParameter("userId"));
		try {
			request.getPart("uploadFile");
			request.getParts();   // 복수개의 파일 처리 
			
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		} 
		
		return "mvc/multipartView";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
