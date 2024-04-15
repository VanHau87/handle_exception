package com.hnguyen387.handle_exception.services;

import com.hnguyen387.handle_exception.dtos.StudentDTO;

public interface StudentService {
	public StudentDTO createStudent(StudentDTO dto);
	public StudentDTO getDetail(String id);
}
