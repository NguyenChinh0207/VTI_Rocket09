package com.vti.service;

import java.util.List;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class AccountService {

	private AccountRepository repository;

	public AccountService() {
		repository = new AccountRepository();
	}

	public List<Account> getAllAccounts() {
		return null;
	}

	public Account getAccountByEmail(String email) {
		return repository.getAccountByEmail(email);
	}

	public boolean isAccountExistsByEmail(String email) {
		return repository.isAccountExistsByEmail(email);
	}

	public void createAccount(AccountDTO dto) {

		Account entity = dto.toEntity();
		repository.createAccount(entity);
	}
}
