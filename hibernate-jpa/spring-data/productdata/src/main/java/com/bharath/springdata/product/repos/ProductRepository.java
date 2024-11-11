package com.bharath.springdata.product.repos;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bharath.springdata.product.entities.Product;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer> ,PagingAndSortingRepository<Product, Integer>{
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name,String desc);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(Double price1,Double price2);
	
	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Integer> ids,PageRequest pageable);
	
	@Query(value="CALL GetAllProducts",nativeQuery = true)
	List<Product> findAllProducts();
	
	@Query(value="CALL GetAllProductsByPrice (:price_in)",nativeQuery = true)
	List<Product> findAllProductsByPrice(double price_in);
	
	@Query(value="CALL GetAllProductsByPrice (:price_in)",nativeQuery = true)
	int findAllProductsCountByPrice(double price_in);
	
	

}
