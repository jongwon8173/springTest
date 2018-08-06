package kr.or.ddit.lprod.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lprod")
@Controller("lprodController")
public class LprodController {  	//실습  jsp프로젝트에서 작성한 - LprodServlet.java을 spring Controller으로 변경해보기
	
	@Resource(name="lprodService")   // service 에 매핑한 서비스이름과 같아야한다.
	private LprodServiceInf lprodService;
	
	// 상품페이지 리스트 처리 
	// 요청 : lprod/lprodList
	@RequestMapping("/lprodList")
	public String lprodList(@RequestParam(value="page", defaultValue="1") int page,
							@RequestParam(value="pageSize", defaultValue="10") int pageSize,
							Model model
							){ // 파리미터 받아서 페이징처리
		
		// 페이지 정보를 Map 객체에 담아 리스트조회하는 메서드로 보냄 
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = lprodService.getLprodPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		return "lprod/lprodList";
	}
	
	
	// 제품 상세정보 조회  / 	/lprod/lprodDetail
	@RequestMapping("/lprodDetail")
	public String lprodDetail(LprodVo vo, Model model){
		
		LprodVo lprodVo = lprodService.getLprod(vo);
		model.addAttribute("lprodVo", lprodVo);
		
		return "lprod/lprodDetail";
	}
	
	
	
	
}
