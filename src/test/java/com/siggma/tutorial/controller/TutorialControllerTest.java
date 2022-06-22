package com.siggma.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siggma.tutorial.model.Student;
import com.siggma.tutorial.service.TutorialService;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TutorialService tutorialService;
	
	@Autowired
    private ObjectMapper mapper;

	@Test
	void getStudentsTest() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ganesh","MCA",0));
		
		when(tutorialService.getStudents()).thenReturn(
				students);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getStudents")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id: 1,name: Ganesh,description: MCA,marks: 0}]"))
				.andReturn();
		
	}

	@Test
	void addStudentTest() throws Exception {
		
		Student student = new Student(1,"Ganesh","MCA",10);
		when(tutorialService.addStudent(student)).thenReturn(
				student);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/addStudent")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(student))
				.content("{\"id\":1,\"name\":\"Ganesh\",\"description\":\"MCA\",\"marks\":10}")
				;
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id: 1,name: Ganesh,description: MCA,marks: 10}"))
				.andReturn();
		
	}
	
	@Test
	void getStudentTest() throws Exception {
		
		when(tutorialService.getStudent(1)).thenReturn(
				new Student(1,"Ganesh","MCA",0));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getStudent/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id: 1,name: Ganesh,description: MCA,marks: 0}"))
				.andReturn();
	}
	
	@Test
	void computeMarksTest() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ganesh","MCA",10));
		
		when(tutorialService.computeMarks()).thenReturn(
				students);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/computeMarks")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id: 1,name: Ganesh,description: MCA,marks: 10}]"))
				.andReturn();
	}
	
	@Test
	void resetMarksTest() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ganesh","MCA",10));
		
		when(tutorialService.resetMarks()).thenReturn(
				students);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/resetMarks")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id: 1,name: Ganesh,description: MCA,marks: 10}]"))
				.andReturn();
	}
	
	@Test
	void deleteStudentTest() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ganesh","MCA",10));
		
		when(tutorialService.deleteStudent(1)).thenReturn(
				"Deleted");
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/resetMarks")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	}
}
