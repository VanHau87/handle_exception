package com.hnguyen387.handle_exception.exceptions;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnguyen387.handle_exception.dtos.StudentDTO;
import com.hnguyen387.handle_exception.services.StudentService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistValidator implements ConstraintValidator<IsExist, StudentDTO>{
	private String field;
	
	@Autowired
	private StudentService service;
	
	@Override
	public void initialize(final IsExist constraintAnnotation) {
		field = constraintAnnotation.field();
	}

	@Override
	public boolean isValid(StudentDTO dto, ConstraintValidatorContext context) {
		final var wrapper = new BeanWrapperImpl(dto);
		final var value = wrapper.getPropertyValue(field);
		boolean isExist = service.isValueExistByFieldName(String.valueOf(value), field);
		if (isExist) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
				.addPropertyNode(field)
				.addConstraintViolation();
		}
		return !isExist;
	}

}
