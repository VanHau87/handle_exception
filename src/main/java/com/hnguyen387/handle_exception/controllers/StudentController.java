package com.hnguyen387.handle_exception.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.handle_exception.dtos.StudentDTO;
import com.hnguyen387.handle_exception.exceptions.OnUpdate;
import com.hnguyen387.handle_exception.services.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping
	public ResponseEntity<StudentDTO> createStudent(
			@Validated
			@RequestBody StudentDTO dto) {
		var student = service.createStudent(dto);
		return new ResponseEntity<StudentDTO>(student, HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<StudentDTO> updateStudent(
			@Validated(OnUpdate.class)
			@RequestBody StudentDTO dto) {
		var student = service.updateStudent(dto);
		return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudendt(@PathVariable String studentId) {
		var student = service.getDetail(studentId);
		return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
	}
}
