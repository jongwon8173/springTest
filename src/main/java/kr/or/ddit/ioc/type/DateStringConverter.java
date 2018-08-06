package kr.or.ddit.ioc.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.core.convert.converter.Converter;
import org.springframework.test.context.ContextConfiguration;

public class DateStringConverter implements Converter <String, Date>{

	private String datePattern;
	
	
	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	public DateStringConverter(String datePattern) {
		this.datePattern = datePattern;
	}
	
	public DateStringConverter() {
		super();
	}

	@Override
	public Date convert(String source) {
		// source : yyyy-MM-dd 형식으로 가정 
		// source : "2018-07-30"
		
		SimpleDateFormat sdf = new SimpleDateFormat(this.datePattern);
		
		Date date = null;
		
		try {
			
			date = sdf.parse(source);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}
}
