package com.main.product;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name="Id")
	private int Id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Price")
	private double price;
	
	@Transient
	private static ArrayList<Product> products;
	
	public static ArrayList<Product> getProducts() {
		return products;
	}

	public Product(){
		super();
	}
	public Product(String name, double price){
		//this.Id = Id;
		this.name = name;
		this.price=price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static void addProduct(Session session, String name, double price) {
		 Transaction tx = session.beginTransaction(); 
		 Product product = new Product(name,price);
		 session.save(product);
		 session.getTransaction().commit();
	}

}
