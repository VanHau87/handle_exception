package com.hnguyen387.handle_exception.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.handle_exception.dtos.SubjectDTO;
import com.hnguyen387.handle_exception.services.SubjectService;

@RestController
@RequestMapping("api/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService service;
	@PostMapping
	public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO dto) {
		var subject = service.createSubject(dto);
		BeanUtils.copyProperties(subject, dto);
		return new ResponseEntity<SubjectDTO>(dto, HttpStatus.CREATED);
	}
}
