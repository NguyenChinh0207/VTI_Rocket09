package com.vti.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short>, JpaSpecificationExecutor<Department>{
	public Department findById(short id) ;
	public Department findByName(String name) ;
	public boolean existsById(short id) ;
	public boolean existsByName(String name) ;
	

}
