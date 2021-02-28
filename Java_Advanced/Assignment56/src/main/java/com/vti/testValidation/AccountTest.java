package com.vti.testValidation;

import com.vti.controller.AccountController;
import com.vti.dto.AccountDTO;

public class AccountTest {
	public static void main(String[] args) {
		AccountController controller = new AccountController();

		System.out.println("\n\n***********CREATE ACCOUNT***********");

		AccountDTO account = new AccountDTO("Nguyenchinh@gmail.comfdassssssssssssssss", "Nguyen Thi Chinh", "Chinh", "Nguyen Thi");

		controller.createAccount(account);

	}
}
