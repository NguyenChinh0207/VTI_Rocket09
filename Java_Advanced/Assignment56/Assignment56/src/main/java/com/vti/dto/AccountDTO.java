package com.vti.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.Account;
import com.vti.validation.EmailNotExists;

public class AccountDTO {

	@NotBlank(message = "{accountDto.email.NotBlank}")
	@Length(max = 50, message = "{accountDto.email.Length}")
	@Email(message = "{accountDto.email.Email }")
	@EmailNotExists
	private String email;

	@NotBlank(message = "The Username mustn't be null value")
	@Length(max = 50, message = "The Username's length is max 50 characters")
	private String username;

	@NotBlank(message = "The First Name mustn't be null value")
	@Length(max = 50, message = "The First Name's length is max 50 characters")
	private String firstName;

	@NotBlank(message = "The Last Name mustn't be null value")
	@Length(max = 50, message = "The Last Name's length is max 50 characters")
	private String lastName;

	public AccountDTO() {
	}

	public AccountDTO(String email, String username, String firstName, String lastName) {
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Account toEntity() {
		return new Account(email, username, firstName, lastName);
	}

}
