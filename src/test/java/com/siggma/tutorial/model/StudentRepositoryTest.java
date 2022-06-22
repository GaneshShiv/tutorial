package com.siggma.tutorial.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// above tile to use actual DB
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository repository;

	@Test
	public void testFindAll() {
		List<Student> items = repository.findAll();
		assertEquals(2,items.size());
	}

}
