package com.bharath.springdata.associations;


import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import com.bharath.springdata.associations.manytomany.entities.Project;
import com.bharath.springdata.associations.manytomany.repos.ProgrammerRepository;
import com.bharath.springdata.associations.onetomany.entities.Customer;
import com.bharath.springdata.associations.onetomany.entities.PhoneNumber;
import com.bharath.springdata.associations.onetomany.repos.CustomerRepository;
import com.bharath.springdata.associations.onetoone.entitites.License;
import com.bharath.springdata.associations.onetoone.entitites.Person;
import com.bharath.springdata.associations.onetoone.repos.LicenseRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();
		customer.setName("John");

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("cell");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("home");

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
	    Optional<Customer> customer = repository.findById(4L);
	    System.out.println(customer.get().getName());
	    
	    Set<PhoneNumber> numbers = customer.get().getNumbers();
	    numbers.forEach(number -> System.out.println(number.getNumber()));
	}
	
	
	@Test
	public void testUpdateCustomer() {
		Optional<Customer> customerOpt = repository.findById(4L);
		Customer customer = customerOpt.get();
		customer.setName("John Bush");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> number.setType("cell"));

		repository.save(customer);
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(4L);
	}
	
	@Test
	public void testmtomCreateProgrammer() {
		
		Programmer programmer = new Programmer();
		programmerRepository.save(programmer);
		programmer.setName("John");
		programmer.setSal(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
	    projects.add(project);
			
		programmer.setProjects(projects);
		
		programmerRepository.save(programmer);
		
		
	}
	@Test
	@Transactional
	public void testmtomFindProgrammer() {
		Optional<Programmer> programmer = programmerRepository.findById(1);
		System.out.println(programmer);
		System.out.println(programmer.get().getProjects());
	}
	
	
	@Test
    public void testOneToOneCreateLicense() {
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());
        
        Person person = new Person();
        person.setFirstname("John");
        person.setLastname("Clinton");
        person.setAge(35);
        
        license.setPerson(person);
        licenseRepository.save(license);
    }

}















