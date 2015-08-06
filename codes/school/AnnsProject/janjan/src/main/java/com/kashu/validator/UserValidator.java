package com.kashu.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kashu.domain.User;

public class UserValidator implements Validator {
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		//return User.class.equals(clazz);
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpassword", "empty.cpassword");
		User user = (User) obj;
		if(!user.getPassword().equals(user.getCpassword())){
			errors.rejectValue("cpassword", "error.passwordDiff");
		}
		if(user.getUsername().length()<4||user.getUsername().length()>14){
			errors.rejectValue("username", "length.username");
		}
		if(user.getPassword().length()<6||user.getPassword().length()>14){
			errors.rejectValue("password", "length.password");
		}
		if(!isEmailValid(user.getEmail())){
			errors.rejectValue("email", "invalid.email");
		}
		
	}
	
	public boolean isEmailValid(String email){
	  Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	  Matcher matcher = pattern.matcher(email);
	  return matcher.matches();
	}
}