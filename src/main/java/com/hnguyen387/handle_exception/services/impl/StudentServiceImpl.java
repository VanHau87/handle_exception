package com.hnguyen387.handle_exception.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnguyen387.handle_exception.dtos.StudentDTO;
import com.hnguyen387.handle_exception.entities.Student;
import com.hnguyen387.handle_exception.exceptions.FailedToSaveData;
import com.hnguyen387.handle_exception.exceptions.NotFoundException;
import com.hnguyen387.handle_exception.repos.StudentRepository;
import com.hnguyen387.handle_exception.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository repository;
	
	@Override
	public StudentDTO createStudent(StudentDTO dto) {
		try {
			Student student = new Student();
			BeanUtils.copyProperties(dto, student);
			student.setId(UUID.randomUUID().toString());
			var savedStudent = repository.save(student);
			StudentDTO savedDto = new StudentDTO();
			BeanUtils.copyProperties(savedStudent, savedDto);
			return savedDto;
		} catch (Exception e) {
			throw new FailedToSaveData(e.getMessage());
		}
		
	}

	@Override
	public StudentDTO getDetail(String id) {
		Optional<Student> optional = repository.findById(id);
		var student = optional.orElseThrow(
				() -> new NotFoundException(String.format("Not found student with id %s.", id)));
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(student, dto);
		return dto;
	}
	
}
