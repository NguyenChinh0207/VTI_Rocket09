package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address", catalog = "TestingSystem5")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String name;

	@OneToOne(mappedBy = "address")
	private DetailDepartment department;

	public Address() {
	}

	public Address(String name) {
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DetailDepartment getDepartment() {
		return department;
	}

	public void setDepartment(DetailDepartment department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
