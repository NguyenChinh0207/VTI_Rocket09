package com.vti.service;

import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Filter;


public interface IDepartmentService {

	public List<Department> getAllDepartments(Filter filter,String search);

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
