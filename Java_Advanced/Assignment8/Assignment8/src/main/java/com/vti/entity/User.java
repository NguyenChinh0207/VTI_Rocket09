package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User", catalog = "TestingSystemBai8")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "password", length = 800, nullable = false)
	private String password;
	
	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "phone", length = 15, nullable = false)
	private String phone;

	
	public User() {
		
	}


	public User(String email, String username, String password, String firstName, String lastName, String phone) {
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}


	public User(short id, String email, String username, String password, String firstName, String lastName,
			String phone) {
		
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
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


	public void setFirstName(String firstName) {
		this.firstName = firstName;
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


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
	
	
	
}
