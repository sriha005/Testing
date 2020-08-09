package com.web;

import org.springframework.stereotype.Repository;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustomerDB extends CrudRepository<Customer,Long> {
	
	List<Customer> findByName(String Name);
	List<Customer> findAll();
	//SQL = @Query(value = "select * from product.cust_product p where p.product_id = :product_id", nativeQuery = true)
	//JPQL:
	@Query(value = "select p from Customer p where p.product_id = :product_id")
	List<Customer> findByproduct_id(@Param("product_id") int product_id);
	
	@Transactional
	@Modifying
	@Query("delete from Customer p WHERE p.Id = :Id")
	void deleteById(@Param("Id") int Id);
	
	void deleteAll();
}
