package com.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.main.product.Product;

public class ProductDB {
	
private static List<Product> products;
	private static Session session;
	public static List<Product> getProducts() {
		return products;
	}
	
	public static void setup() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		 Setup hibernate = (Setup)context.getBean("hibersetup");
		 session = hibernate.getSession();
		// ProductDB.addProduct(session, "dog", 20.0);
		// ProductDB.getAllProducts(session);
		// session.close();
	}
	
	public static void addProduct(String name, double price) {
		 Transaction tx = session.beginTransaction(); 
		 Product product = new Product(name,price);
		 session.save(product);
		 session.getTransaction().commit();
	}
	
	public static void getAllProducts() {
		Query q = session.createQuery("from Product");
		List<Product> list = q.list();
		for(Product p:list) {
			System.out.println("ID: " + (p.getId()));
			System.out.println("Name: " + (p.getName()));
			System.out.println("Price: " + (p.getPrice()));
		}
		products = list;
	}
	public static void close() {
		session.close();
	}
	
}
