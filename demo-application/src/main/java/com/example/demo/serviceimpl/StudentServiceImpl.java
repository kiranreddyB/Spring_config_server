package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepositiry;
import com.example.demo.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepositiry studentRepositiry;
	
	@Override
	public Student save(Student student) {
		
		return studentRepositiry.save(student);
	}

	@Override
	public Student featchStudent(int id) {
		
		Optional<Student> student = studentRepositiry.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		
		
		return null;
	}

	

}
