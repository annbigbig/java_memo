package com.kashu.test.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.kashu.test.domain.Member;

public class MemberValidator implements Validator{
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "membername", "empty.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpassword", "empty.cpassword");
		Member member = (Member) obj;
		if(!member.getPassword().equals(member.getCpassword())){
			errors.rejectValue("cpassword", "error.passwordDiff");
		}
		if(member.getMembername().length()<6||member.getMembername().length()>14){
			errors.rejectValue("membername", "length.username");
		}
		if(member.getPassword().length()<6||member.getPassword().length()>14){
			errors.rejectValue("password", "length.password");
		}
		if(!isEmailValid(member.getEmail())){
			errors.rejectValue("email", "invalid.email");
		}
		
	}
	
	public boolean isEmailValid(String email){
	  Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	  Matcher matcher = pattern.matcher(email);
	  return matcher.matches();
	}

}
