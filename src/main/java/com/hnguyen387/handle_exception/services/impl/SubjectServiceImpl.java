package com.hnguyen387.handle_exception.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnguyen387.handle_exception.dtos.SubjectDTO;
import com.hnguyen387.handle_exception.entities.Subject;
import com.hnguyen387.handle_exception.exceptions.FailedToSaveData;
import com.hnguyen387.handle_exception.exceptions.NotFoundException;
import com.hnguyen387.handle_exception.repos.SubjectRepository;
import com.hnguyen387.handle_exception.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository repository;
	
	@Override
	public Subject createSubject(SubjectDTO dto) {
		try {
			Subject subject = new Subject();
			BeanUtils.copyProperties(dto, subject);
			return repository.save(subject);
		} catch (Exception e) {
			throw new FailedToSaveData(e.getMessage());
		}
	}

	@Override
	public SubjectDTO getSubject(Integer id) {
		Optional<Subject> optional = repository.findById(id);
		var subject = optional.orElseThrow(
				() -> new NotFoundException(String.format("Not found subject with id: %d.", id)));
		SubjectDTO dto = new SubjectDTO();
		BeanUtils.copyProperties(subject, dto);
		return dto;
	}

}
