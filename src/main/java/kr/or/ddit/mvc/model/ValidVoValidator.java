package kr.or.ddit.mvc.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidVoValidator implements Validator {

	// ValidVo에 대한 검증을 위한 Validator _________________
	
	
	// 확인하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		return ValidVo.class.isAssignableFrom(clazz);
	}
	
	
	// 실제 로직이 들어가는 부분
	@Override
	public void validate(Object target, Errors errors) {
		ValidVo vo = (ValidVo) target;

		// 검증에대한 로직을 각 회사의 상황에 맞게 작성

		
		// userId 는 null 혹은 whitespace 이면 안된다.
		if (vo.getUserId() == null || vo.getUserId().equals(""))
			errors.rejectValue("userId", "notNull");

		
		// name 는 null 혹은 whitespace 이면 안된다.
		if (vo.getName() == null || vo.getName().equals(""))
			errors.rejectValue("name", "notNull");

		
		// password 는 null 혹은 whitespace 이면 안된다.
		// password 는 4자리 이상이어야 한다.
		if (vo.getPassword() == null || vo.getPassword().equals(""))
			errors.rejectValue("password", "notNull");
		else if ( vo.getPassword().length() < 4 )  // 4자리 이하면 에러
			errors.rejectValue("password", "size");

	}
}
