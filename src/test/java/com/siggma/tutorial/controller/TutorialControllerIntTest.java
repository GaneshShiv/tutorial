package com.siggma.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siggma.tutorial.model.Student;
import com.siggma.tutorial.model.StudentRepository;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TutorialControllerIntTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
    private ObjectMapper mapper;
	
//	 to mock only repo or any external bean or rest template exchange
//	@MockBean
//	private StudentRepository studentRepository;
	
	@Test
	void test() throws JsonProcessingException {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ganesh","Math Marks",20));
		students.add(new Student(2,"Sanju","Math Marks",50));
		
//		 to mock only repo or any external bean or rest template exchange		
//		when(studentRepository.findAll()).thenReturn(students);	

		
		String response = this.restTemplate.getForObject("/getStudents", String.class);
//		assertEquals("[{\"id\":1,\"name\":\"Ganesh\",\"description\":\"Math Marks\",\"marks\":20},{\"id\":2,\"name\":\"Sanju\",\"description\":\"Math Marks\",\"marks\":50}]",response);
		assertEquals(mapper.writeValueAsString(students),response);
	}

}
