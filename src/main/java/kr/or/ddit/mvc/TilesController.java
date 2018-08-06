package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*<!-- 해보기
kr.or.ddit.mvc.TilesController 만들고 

url : localhost:8180/tiles/main 로 요청 보냈을떄 

public String tilesMain(){  타도록 
	return "";    //tiles definition name 
}
-->*/

@RequestMapping("/tiles")
@Controller
public class TilesController {
	
	@RequestMapping("/main")
	public String tilesMain(){
		
		return "main";   //tiles-config.xml ==> <definition name="main"
	}

}
