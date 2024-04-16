package com.hnguyen387.handle_exception.repos.impl;


import com.hnguyen387.handle_exception.entities.Student;
import com.hnguyen387.handle_exception.repos.CustomStudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomStudentRepoImpl implements CustomStudentRepo {
	
	@PersistenceContext
	private EntityManager manager;
	@Override
	public Student hasValueExist(String value, String fieldName) {
		fieldName = formatFieldName(fieldName);
		String queryStr = "SELECT * FROM student s WHERE s." + fieldName + " = :value LIMIT 1";
		try {
			return (Student) manager.createNativeQuery(queryStr, Student.class)
                    .setParameter("value", value)
                    .getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	private String formatFieldName(String fieldName) {
		if (fieldName == null) {
	        return null;
	    }
	    StringBuilder result = new StringBuilder();
	    result.append(Character.toLowerCase(fieldName.charAt(0)));

	    for (int i = 1; i < fieldName.length(); i++) {
	        char ch = fieldName.charAt(i);
	        if (Character.isUpperCase(ch)) {
	            result.append('_').append(Character.toLowerCase(ch));
	        } else {
	            result.append(ch);
	        }
	    }
	    return result.toString();
	}
}
