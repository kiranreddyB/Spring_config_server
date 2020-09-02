package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greetings() {
		return "Hello Spring boot from GET";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String grettings2() {
		return "Hello spring boot from POST";
	}
	
	@RequestMapping(value = "/student" , method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
		
	}
	
	@RequestMapping(value= "/student", method = RequestMethod.GET)
	
	public ResponseEntity<Student> featchStudentData(@RequestParam int id) {
	
		Student student = studentService.featchStudent(id);
		if(student == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(student);
		}
	
	}
}
