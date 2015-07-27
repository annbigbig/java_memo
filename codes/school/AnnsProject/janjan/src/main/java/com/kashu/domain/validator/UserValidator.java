package com.kashu.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kashu.domain.User;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpassword", "empty.cpassword");
		User user = (User) obj;
		if(!user.getPassword().equals(user.getCpassword())){
			errors.rejectValue("cpassword", "error.passwordDiff");
		}
	}
}
