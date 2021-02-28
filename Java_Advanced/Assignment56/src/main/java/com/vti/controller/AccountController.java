package com.vti.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.AccountService;
import com.vti.utils.ValidationUtils;

public class AccountController {

	private AccountService service;

	public AccountController() {
		service = new AccountService();
	}

	public List<Account> getAllAccounts() {
		return null;
	}

	public void createAccount(@Valid AccountDTO dto) {
		Locale.setDefault(new Locale("vi", "VN"));
		// Locale.setDefault(Locale.US);
		// validate
		if (ValidationUtils.validate(dto)) {
			// validate success
			service.createAccount(dto);
		}
	}
}
