package kr.or.ddit.ioc.type;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class IocFormattionVo {

	// 1 . @DateTimeFormat
	// 2 . @NumberFormat
	
	private String name;
	
	// ================================================
	// 1 . @DateTimeFormat
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDt;
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date modDt;
	
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	
	// ================================================	
	
	
	//================================================
	//  2 . @NumberFormat
	@NumberFormat(pattern="#,###")
	private int amount;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	//================================================
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
