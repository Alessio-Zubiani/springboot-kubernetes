package com.example.kubernetes.service;

import java.util.List;
import java.util.Optional;

import com.example.kubernetes.entity.Employee;
import com.example.kubernetes.exception.EmployeeNotFoundException;
import com.example.kubernetes.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;
	private final MessageService messageService;
	
	
	@Override
	public Employee createEmployee(Employee e) throws JsonProcessingException, JMSException {
		
		e = this.repository.save(e);
		this.messageService.sendMessage(e);
		
		return e;
	}

	@Override
	public List<Employee> getEmployees() {
		
		return this.repository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		
		Optional<Employee> o = this.repository.findById(id);
		if(o.isEmpty()) {
			throw new EmployeeNotFoundException(new StringBuilder("Not found Employee with id: [").append(id).append("]").toString());
		}
		
		return o.get();
	}

}
