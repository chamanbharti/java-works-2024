package com.bharath.springdata.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.springdata.data.entities.Customer;
import com.bharath.springdata.data.entities.CustomerId;

public interface CustomerRepo extends JpaRepository<Customer, CustomerId> {

}
