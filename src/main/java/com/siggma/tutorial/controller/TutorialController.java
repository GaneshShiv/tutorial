package com.siggma.tutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siggma.tutorial.model.Student;
import com.siggma.tutorial.service.TutorialService;

@RestController
@CrossOrigin
public class TutorialController {

	@Autowired
	TutorialService tutorialService;
	
	@GetMapping("/appHealth")
	public String appHealth() {
		return "Healthy";
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return tutorialService.getStudents();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return tutorialService.addStudent(student);
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id) {
		return tutorialService.getStudent(id);
	}
	
	@GetMapping("/computeMarks")
	public List<Student> computeMarks() {
		return tutorialService.computeMarks();
	}
	
	@GetMapping("/resetMarks")
	public List<Student> resetMarks() {
		return tutorialService.resetMarks();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		tutorialService.deleteStudent(id);
	}
}
