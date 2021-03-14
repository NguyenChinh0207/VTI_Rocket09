package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vti.entity.Department;
import com.vti.entity.Filter;
import com.vti.service.IDepartmentService;




@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class DepartmentController {

	@Autowired
	private IDepartmentService service;
	@GetMapping()
	public ResponseEntity<?> getAllDepartments(Filter filter,String search) {
		// get data
		List<Department> entities = service.getAllDepartments(filter,search);
		return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);
	}
	
}
