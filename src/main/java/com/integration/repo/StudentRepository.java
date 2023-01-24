package com.integration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integration.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
