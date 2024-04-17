package com.neopane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neopane.model.Employee;
import com.neopane.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
    
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getAllEmployeeByID(@PathVariable("id") long eid){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long eid, @RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, eid),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long eid){
		
		employeeService.deleteById(eid);
		
		return new ResponseEntity<String>("Employee succesfully deleted! ",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
