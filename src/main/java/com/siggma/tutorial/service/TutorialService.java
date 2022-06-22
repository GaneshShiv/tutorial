package com.siggma.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.siggma.tutorial.model.Student;
import com.siggma.tutorial.model.StudentRepository;

@Service
public class TutorialService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();		
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudent(int id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> computeMarks() {
		List<Student> students =  studentRepository.findAll();
		for (Student student : students) {
			student.setMarks(student.getId()*10);
		}
		return students;
	}

	public List<Student> resetMarks() {
		List<Student> students =  studentRepository.findAll();
		for (Student student : students) {
			student.setMarks(0);
		}
		return students;
	}

	public String deleteStudent(int id) {
		Optional<Student> student = studentRepository.findById(id);
		studentRepository.delete(student.get());
		return "Deleted";
	}
}
