package kr.or.ddit.user.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserVo implements HttpSessionBindingListener{
	
	private Logger logger = LoggerFactory.getLogger(UserVo.class);	// 2018.07.16 추가
	
	private String userId;
	private String password;
	private String userNm;
	


	public UserVo() {

	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	
	
	public boolean validateUser(String userId, String password){
		
		if (userId.equals(this.getUserId())  && password.equals(this.getPassword()))
			return true;
		else 
			return false;
	}
	
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", password=" + password
				+ ", userNm=" + userNm + "]";
	}
	
	// ========================================================  2018.07.16
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// session 객체에서 session.setAttribute("userVo", uservo)가 호출 되었을때
		logger.debug("httpSessionBinding valuesBound : " +event.getName());
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// session 객체에서 session.removeAttribute("userVo", uservo)가 호출 되었을때
		logger.debug("httpSessionUnBinding valuesBound : " + event.getName());
		
	}
}
