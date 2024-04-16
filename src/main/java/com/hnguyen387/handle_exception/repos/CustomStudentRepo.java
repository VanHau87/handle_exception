package com.hnguyen387.handle_exception.repos;

import com.hnguyen387.handle_exception.entities.Student;

public interface CustomStudentRepo {
	Student hasValueExist(String value, String fieldName);
}
