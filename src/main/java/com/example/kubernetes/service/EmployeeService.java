package com.example.kubernetes.service;

import java.util.List;

import com.example.kubernetes.entity.Employee;
import com.example.kubernetes.exception.EmployeeNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.jms.JMSException;

public interface EmployeeService {
	
	Employee createEmployee(Employee e) throws JsonProcessingException, JMSException;
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(int id) throws EmployeeNotFoundException;

}
