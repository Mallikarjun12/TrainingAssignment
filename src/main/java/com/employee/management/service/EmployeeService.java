package com.employee.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Address;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// fetching all employees
	public List<Employee> getAllEmployees(){
		List<Employee> emps = (List<Employee>)employeeRepository.findAll(); 
		return emps;
	}
	
	// fetching employee by id
	public Employee getEmployee(long id){
		return employeeRepository.findOne(id);
	}
	
	// inserting employee
	public void addEmployee(Employee e) {
		for(Address address : e.getAddress()) {
			address.setEmployee(e);
		}
		employeeRepository.save(e);
	}
	
	// updating employee by id
	public void updateEmployee(Employee emp, int id){
		if(id == emp.getEmp_id()) {
			employeeRepository.save(emp);
		}
	}
	
	// deleting all employees
	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}
	
	// deleting employee by id
	public void deleteEmployeeByID(long id){
		employeeRepository.delete(id);
	}
	
	//patching/updating employee by id
	public void patchEmployee(Employee emp, int id) {
		if(id == emp.getEmp_id()) {
			employeeRepository.save(emp);
		}
	}
}
