package com.neopane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neopane.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
