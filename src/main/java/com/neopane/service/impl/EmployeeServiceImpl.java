package com.neopane.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.neopane.exception.ResourceNotFoundException;
import com.neopane.model.Employee;
import com.neopane.repository.EmployeeRepository;
import com.neopane.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		 
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
	 
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		 
		 Optional<Employee> employee = empRepo.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }
		 else {
			 throw new ResourceNotFoundException("Employee", "Id", id);
		 }
	}

	@Override
	public  Employee  updateEmployee(Employee employee, long id) {
		 
		 Employee existingemployee  = empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		 existingemployee.setFirstName(employee.getFirstName());
		 existingemployee.setLastName(employee.getLastName());
		 existingemployee.setEmail(employee.getEmail());
		 empRepo.save(existingemployee);
		 return existingemployee ;
	}

	@Override
	public void deleteById(long id) {
		 
		
		    empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
	    	empRepo.deleteById(id);
		 
	}

	 

}
