package com.example.kubernetes.controller;

import java.util.List;

import com.example.kubernetes.entity.Employee;
import com.example.kubernetes.service.EmployeeService;
import com.example.kubernetes.service.MessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.jms.JMSException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final MessageService messageService;
	
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.createEmployee(e));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getEmployeeById(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> sendEmployee(@RequestBody Employee e) throws JMSException {
		this.messageService.sendMessage(e);
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}

}
