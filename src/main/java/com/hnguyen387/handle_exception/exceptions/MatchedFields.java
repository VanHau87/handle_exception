package com.hnguyen387.handle_exception.exceptions;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = MatchedFieldsValidator.class)
public @interface MatchedFields {
	String message() default "The value already exists.";
	Class<?>[] groups() default {};
	String first();
	String second();
	
	@Retention(RUNTIME)
	@Target(TYPE)
	@interface List {
    	MatchedFields[] value();
    }
}
