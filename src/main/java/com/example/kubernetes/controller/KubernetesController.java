package com.example.kubernetes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kubernetes")
public class KubernetesController {
	
	@GetMapping
	public ResponseEntity<String> getHello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello Kubernetes");
	}

}
