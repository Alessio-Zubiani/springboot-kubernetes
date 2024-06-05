package com.example.kubernetes.service;

import java.util.List;

import com.example.kubernetes.entity.Employee;
import com.example.kubernetes.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	Employee createEmployee(Employee e);
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(int id) throws EmployeeNotFoundException;

}
