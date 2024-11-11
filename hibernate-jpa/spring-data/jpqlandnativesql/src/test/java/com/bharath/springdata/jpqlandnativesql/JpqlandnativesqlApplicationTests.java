package com.bharath.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.bharath.springdata.jpqlandnativesql.entities.Student;
import com.bharath.springdata.jpqlandnativesql.repos.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("John");
		student.setLastname("Ferguson");
		student.setScore(88);

		Student student2 = new Student();
		student2.setFirstName("Bill");
		student2.setLastname("Gates");
		student2.setScore(75);

		repository.save(student);
		repository.save(student2);
	}

	@Test
	void testFindAllStudents() {
		System.out.println(repository.findAllStudents(PageRequest.of(0,5,Direction.DESC,"id")));
	}

	@Test
	void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("Bill"));
	}

	@Test
	public void testFindAllStudentsByScores() {
		System.out.println(repository.findStudentsForGivenScores(80, 90));
	}
	
	@Test
	@Transactional
	public void testDeleteStudentsByFirstName(){
		repository.deleteStudentsByFirstName("Bill");
		
	}
	
	@Test
	public void testFindAllStudentNQ() {
		System.out.println(repository.findAllStudentNQ());
	}
	
	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirstNQ("Bill"));
	}
	
	
	
	
	
	
	

}
