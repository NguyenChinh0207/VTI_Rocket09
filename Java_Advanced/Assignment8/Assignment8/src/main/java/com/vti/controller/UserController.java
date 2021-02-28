package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.entity.User;
import com.vti.service.IDepartmentService;
import com.vti.service.IUserService;

@RestController
@RequestMapping(value = "api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class UserController {
	@Autowired
	private IUserService service;
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getUserByName(@PathVariable(name = "username") String username) {
		return new ResponseEntity<User>(service.getUserByName(username), HttpStatus.OK);
	}
}
