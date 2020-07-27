package com.employee.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id", updatable = false)
	private long dept_id;
	
	private String deptName;
	
	private String location;

	public Department() {
		super();
	}

	public Department(long dept_id, String deptName, String location) {
		super();
		this.dept_id = dept_id;
		this.deptName = deptName;
		this.location = location;
	}

	public long getDept_id() {
		return dept_id;
	}

	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", deptName=" + deptName + ", location=" + location + "]";
	}


}
