package kr.or.ddit.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.util.FileUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

public class FileDownloadView implements View{   // JsonController.java 에 작성한 @RequestMapping("fileDown")

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	
	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		//fileName
		String fileName = (String) model.get("fileName");
		String originalFileName = (String) model.get("originalFileName");
		
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\"" ); 
														//     filename=\"sally.png\""
		response.setContentType("application/octet-stream");
		
//		// FileUtil.fileUploadPath : sally.png
//		// 파라미터로 파일명 제공 
//		// localhost:8180/fileDownLoad?fileName=sally.png
//		String fileName = request.getParameter("fileName");     - servlet환경에서 적용
		
		// D:\W\A_TeachingMaterial\7.JspSrpgin\fileUpload/sally.png
		String file = FileUtil.fileUploadPath + File.separator + fileName;
		
		// file 입출력을 위한 준비 
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while( ( len = fis.read(b) ) != -1 ){
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
		
	}
	

}
