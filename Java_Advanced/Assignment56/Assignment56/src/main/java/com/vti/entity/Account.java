package com.vti.entity;

import com.vti.validation.EmailNotExists;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Account`", catalog = "TestingSystem5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false)
	private String lastName;

	@Formula(" concat(FirstName, ' ', LastName) ")
	private String fullName;

	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID")
	private Position position;

	@ManyToOne
	@JoinColumn(name = "SalaryID")
	private Salary salary;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@OneToMany(mappedBy = "creator")
	private List<Group> createdGroup;

	@OneToMany(mappedBy = "account")
	private List<GroupAccount> groups;

	public Account() {
	}

	public Account(String email, String username, String firstName, String lastName) {
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getFullName() {
		return fullName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Group> getCreatedGroup() {
		return createdGroup;
	}

	public void setCreatedGroup(List<Group> createdGroup) {
		this.createdGroup = createdGroup;
	}

	public List<GroupAccount> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupAccount> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department + ", position="
				+ position + ", salary=" + salary + ", createDate=" + createDate + "]";
	}

}
