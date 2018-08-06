package kr.or.ddit.mvc.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidJsr303Vo {   // 어노테이션을 이용한 방법 
	// userId, name, password 
	
	@NotEmpty
	private String userId;
	
	@NotEmpty
	private String name;
	
//	@Size(min=4, max=20)
//	@NotEmpty
	@NotEmpty(message = "비밀번호 입력은 필수 입니다")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "비밀 번호는 6~20자리로 숫자와 특수 문자가 포함된 영문 대소문자로 입력해 주세요")
	private String password;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
