package com.integration.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.model.Student;
import com.integration.repo.StudentRepository;
import com.integration.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	

	public Integer saveStudent(Student s) {
		s = repo.save(s);
		return s.getStdId();
	}


	public void updateStudent(Student s) {
		repo.save(s);
		
	}


	public void deleteStudent(Integer id) {
		repo.deleteById(id);
		
	}


	public Student getOneStudent(Integer id) {
		Optional<Student> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	
	public List<Student> getAllStudent() {	
		return  repo.findAll();
	}

}
