package com.employee.management.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long add_id;

	private String addressline;

	private String city;

	private String state;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee employee;

	public Address() {
		super();
	}

	public Address(long add_id, String addressline, String city, String state, Employee employee) {
		super();
		this.add_id = add_id;
		this.addressline = addressline;
		this.city = city;
		this.state = state;
		this.employee = employee;
	}

	public long getAdd_id() {
		return add_id;
	}

	public void setAdd_id(long add_id) {
		this.add_id = add_id;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", addressline=" + addressline + ", city=" + city + ", state=" + state
				+ ", employee=" + employee + "]";
	}
	

}
