package com.vti.program;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;

import java.util.List;

public class SalaryTest {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		System.out.println("***********GET ALL SALARYS***********");

		List<Salary> Salarys = repository.getAllSalarys();

		for (com.vti.entity.Salary Salary : Salarys) {
			System.out.println(Salary);
		}

		System.out.println("\n\n***********CREATE SALARY***********");

		Salary SalaryCreate = new Salary();
		SalaryCreate.setName(SalaryName.PM);
		repository.createSalary(SalaryCreate);

	}
}
