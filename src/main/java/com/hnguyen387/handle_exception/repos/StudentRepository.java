package com.hnguyen387.handle_exception.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnguyen387.handle_exception.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
