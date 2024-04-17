package com.neopane.service;

import java.util.List;

import com.neopane.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id) ;
	
	void deleteById(long id);
}
