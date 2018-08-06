package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class ExcelDownloadView implements View {   // jsp - excelDown.jsp 를 이용 

	@Override
	public String getContentType() {
		
		return "application/vnd.ms-excel; charset=UTF-8";
	}

	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
		response.setHeader("Content-Description", "JSP Generated Data");
		response.setContentType("application/vnd.ms-excel");
		
		List<String> rangers = (List<String>) model.get("rangers");
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<table>");
		for (String ranger : rangers) {
			pw.write("<tr>");
				pw.write("<td>" + ranger + "</td>" );
			pw.write("</tr>");
		}
		pw.write("</table>");
		
	}

}
