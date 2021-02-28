package com.vti.dto;

import com.vti.entity.Department;

public class DepartmentDTO {
	private String name;
	private short totalMember;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public short getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(short totalMember) {
		this.totalMember = totalMember;
	}

	public DepartmentDTO() {
	}

	public Department toEntity() {
		return new Department(name,totalMember);
	}

}
