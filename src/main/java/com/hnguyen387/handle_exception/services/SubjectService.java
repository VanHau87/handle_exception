package com.hnguyen387.handle_exception.services;

import com.hnguyen387.handle_exception.dtos.SubjectDTO;
import com.hnguyen387.handle_exception.entities.Subject;

public interface SubjectService {
	public Subject createSubject(SubjectDTO dto);
	public SubjectDTO getSubject(Integer id);
}
