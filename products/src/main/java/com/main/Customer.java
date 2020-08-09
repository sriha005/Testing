package com.main;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;


import java.time.ZonedDateTime;
@Entity
@Table(name="cust_product")
public class Customer {

	@Id
	@Column(name="Id")
	int Id;

	@Column(name="name")
	String name;
	
	@Column(name="product_id")
	int product_id;
	
	public Customer() {
		super();
	}
	public Customer(String name, int productId) {
		super();
		
		this.name = name;
		this.product_id = productId;
	}
	
	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductId() {
		return product_id;
	}
	public void setProductId(int productId) {
		product_id = productId;
	}
	
	
	
}
