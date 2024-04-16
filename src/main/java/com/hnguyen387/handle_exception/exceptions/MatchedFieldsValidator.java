package com.hnguyen387.handle_exception.exceptions;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatchedFieldsValidator implements ConstraintValidator<MatchedFields, Object>{
	private String first;
	private String second;

	@Override
	public void initialize(final MatchedFields constraintAnnotation) {
		first = constraintAnnotation.first();
		second = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		final var wrapper = new BeanWrapperImpl(value);
		final var firstValue = wrapper.getPropertyValue(first);
		final var secondValue = wrapper.getPropertyValue(second);
		boolean valid = (firstValue == null && secondValue == null) || 
				(firstValue != null && firstValue.equals(secondValue));
		if (!valid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode(first)
					.addConstraintViolation();
			
		}
		return valid;
	}

}
