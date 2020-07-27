package com.employee.management.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_id;
	
	private String firstName;
	
	private String lastname;
	
	private double salary;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date DOJ;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "deptartment_id")
	private Department department;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Address> address;

	public Employee() {
		super();
	}

	public Employee(long emp_id, String firstName, String lastname, double salary, Date dOJ, Department department,
			List<Address> address) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.salary = salary;
		DOJ = dOJ;
		this.department = department;
		this.address = address;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", firstName=" + firstName + ", lastname=" + lastname + ", salary="
				+ salary + ", DOJ=" + DOJ + ", department=" + department + ", address=" + address + "]";
	}
		
}
