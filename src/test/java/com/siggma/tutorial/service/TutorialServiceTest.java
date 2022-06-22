package com.siggma.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.siggma.tutorial.model.Student;
import com.siggma.tutorial.model.StudentRepository;

@ExtendWith(MockitoExtension.class)
class TutorialServiceTest {

	@InjectMocks
	private TutorialService tutorialService;
	
	@Mock
	private StudentRepository studentRepository;
	
	@Test
	void getStudentsTest() {
		
		List<Student> data = new ArrayList<Student>();
		data.add(new Student(1,"Ganesh","MCA",0));
		
		when(studentRepository.findAll()).thenReturn(data);		
		List<Student> students = tutorialService.getStudents();
		assertEquals(data,students);
	}
	
	@Test
	void addStudentTest() {
		
		Student data = new Student(1,"Ganesh","MCA",0);
		
		when(studentRepository.save(data)).thenReturn(data);		
		Student student = tutorialService.addStudent(data);
		assertEquals(data,student);
	}
	
	@Test
	void getStudentTest() {
		Optional<Student>  data = Optional.ofNullable(new Student(1,"Ganesh","MCA",0));
				
		when(studentRepository.findById(1)).thenReturn(data);		
		Student students = tutorialService.getStudent(1);
		assertEquals(data.get(),students);
	}
	
	@Test
	void computeMarksTest() {
		
		List<Student> data = new ArrayList<Student>();
		data.add(new Student(1,"Ganesh","MCA",0));
		
		List<Student> expected = new ArrayList<Student>();
		expected.add(new Student(1,"Ganesh","MCA",10));
		
		when(studentRepository.findAll()).thenReturn(data);		
		List<Student> students = tutorialService.computeMarks();
		assertEquals(expected,students);
	}
	
	@Test
	void resetMarksTest() {
		
		List<Student> data = new ArrayList<Student>();
		data.add(new Student(1,"Ganesh","MCA",10));
		
		List<Student> expected = new ArrayList<Student>();
		expected.add(new Student(1,"Ganesh","MCA",0));
		
		when(studentRepository.findAll()).thenReturn(data);		
		List<Student> students = tutorialService.resetMarks();
		assertEquals(expected,students);
	}
	
	@Test
	void deleteStudentTest() {
		
		Optional<Student>  data = Optional.ofNullable(new Student(1,"Ganesh","MCA",0));
		
		when(studentRepository.findById(1)).thenReturn(data);		
		String result = tutorialService.deleteStudent(1);
		Mockito.verify(studentRepository, times(1)).delete(data.get());
		assertEquals("Deleted",result);
	}

}
