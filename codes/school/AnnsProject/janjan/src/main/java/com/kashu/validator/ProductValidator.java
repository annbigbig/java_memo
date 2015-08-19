package com.kashu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kashu.domain.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty.product.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unit", "empty.product.unit");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "empty.product.price");
	}

}
