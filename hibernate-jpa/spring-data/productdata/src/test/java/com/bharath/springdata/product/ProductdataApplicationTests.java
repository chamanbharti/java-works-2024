package com.bharath.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.springdata.product.entities.Product;
import com.bharath.springdata.product.repos.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		repository.save(product);
	}

	@Test
	void testRead() {
		Product product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("IPhone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + product.getDesc());

	}

	@Test
	void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);

	}

	@Test
	void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}

	@Test
	void testCount() {
		System.out.println("total records===============>>>>>>>>>>>>>>" + repository.count());
	}

	@Test
	public void testFindByName() {
		List<Product> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdsIn() {
		PageRequest pageable = PageRequest.of(1, 2);
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		PageRequest pageable = PageRequest.of(1, 2);

		Page<Product> results = repository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindAllSorting() {
		repository.findAll(Sort.by(Direction.DESC, "name").and(Sort.by("price")));
		// repository.findAll(Sort.by(Direction.DESC,"name","price")).forEach(p->
		// System.out.println(p.getName()));

	}

	@Test
	public void testFindAllPagingAndSorting() {
		PageRequest pageable = PageRequest.of(1, 2, Direction.DESC, "name");
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));

	}
	
	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Optional<Product> product = repository.findById(1);	
		repository.findById(1);	
		session.evict(product);	
		repository.findById(1);
		
	}
	
	@Test
	public void testFindAllProducts() {
		System.out.println(repository.findAllProducts());		
	}
	
	@Test
	public void testFindAllProductsByPrice() {
		System.out.println(repository.findAllProductsByPrice(800));		
	}
	
	@Test
	public void testFindAllProductsCountByPrice() {
		System.out.println(repository.findAllProductsCountByPrice(800));		
	}
}















