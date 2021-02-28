package com.vti.dto;

import com.vti.entity.Department;
import com.vti.entity.User;

public class UserDTO {
	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	
	
	public UserDTO() {
		
	}
	public User toEntity() {
		return new User(email,username,password, firstName, lastName, phone);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firtName) {
		this.firstName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
