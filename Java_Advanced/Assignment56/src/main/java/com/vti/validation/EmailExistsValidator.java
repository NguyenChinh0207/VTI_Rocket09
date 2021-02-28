package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mysql.cj.util.StringUtils;
import com.vti.service.AccountService;

public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {

	private AccountService service;

	@Override
	public void initialize(EmailExists annotation) {
		service = new AccountService();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isNullOrEmpty(value)) {
			return false;
		}

		return service.isAccountExistsByEmail(value);
	}
}