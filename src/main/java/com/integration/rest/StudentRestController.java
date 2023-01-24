package com.integration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.model.Student;
import com.integration.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	// save
	@PostMapping("/create")
	public ResponseEntity<String> saveStudent(@RequestBody Student stuent)
	
	{
		
		Integer id = service.saveStudent(stuent);
		String body = "student record saved no : "+ " " + id;
		return ResponseEntity.ok(body);
	}
	
	// fetch all
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getallStudents()
	
	{
		List<Student> list =service.getAllStudent();
		return ResponseEntity.ok(list);
	}
	
	// fetch one
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer id)
	
	{
		Student s = service.getOneStudent(id);
		return ResponseEntity.ok(s);
		
	}
	
	
	// delete
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
	{
		service.deleteStudent(id);
		String body = "student has been deleted";
		return ResponseEntity.ok(body);
		
	}
	
	// update all	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Student student)
	
	{
		service.updateStudent(student);
		String body = "Student has been updated " + student.getStdId();
		return ResponseEntity.ok(body);
		
	}
}
