package com.vti.program;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

import java.util.List;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		System.out.println("***********GET ALL***********");

		List<Employee> employees = repository.getAllEmployees();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("\n\n***********CREATE***********");
	}
}
