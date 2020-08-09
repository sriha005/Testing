package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.main.dao.ProductDB;
import com.main.dao.Setup;
import com.main.product.Product;

public class main {
	
	public static void main( String[] args )
    {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		 Setup hibernate = (Setup)context.getBean("hibersetup");
		 Session session = hibernate.getSession();
		// ProductDB.addProduct(session, "dog", 20.0);*/
		ProductDB.setup();
		 ProductDB.getAllProducts(); 
		 List<Product> list = ProductDB.getProducts(); 
		 
		
			for(Product p:list) {
				System.out.println("ID: " + (p.getId()));
				System.out.println("Name: " + (p.getName()));
				System.out.println("Price: " + (p.getPrice()));
		 }
			ProductDB.close();
			
    }
}
