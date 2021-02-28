package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department", catalog = "TestingSystem5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Account> accounts;

	public Department() {
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department { " + "ID = " + id + ", Name = '" + name + '\'' + '}';
	}

}
