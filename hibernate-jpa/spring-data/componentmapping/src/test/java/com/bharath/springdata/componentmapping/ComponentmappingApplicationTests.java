package com.bharath.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.springdata.componentmapping.entities.Address;
import com.bharath.springdata.componentmapping.entities.Employee;
import com.bharath.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("Bharath");

		Address address = new Address();
		address.setCity("Austin");
		address.setStreetaddress("Spicewood Springs");
		address.setCountry("USA");
		address.setState("Texas");
		address.setZipcode("78750");
		employee.setAddress(address);
		repository.save(employee);

	}

}
