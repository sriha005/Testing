package com.main.control;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.dao.ProductDB;
import com.main.product.Product;
import com.main.Customer;  

@Controller
public class DisplayController {
	@RequestMapping("/show") 
	public String redirect(Model m)  
	    {  
			ProductDB.setup(); 
			ProductDB.getAllProducts();
			
			List<Product> list = ProductDB.getProducts();
			Client client = ClientBuilder.newClient();
			 String REST_SERVICE_URL = "http://localhost:8081/demo/cust";
			 GenericType<List<Customer>> list2 = new GenericType<List<Customer>>() {};
		     List<Customer> users = client
		      .target(REST_SERVICE_URL)
		        .request().accept(MediaType.APPLICATION_JSON)
		         .get(list2);
			 ProductDB.close();
			 
		     m.addAttribute("list",list);  
		     m.addAttribute("list2",users);  
	        return "viewpage";  
	    }    
	@RequestMapping("/addpage")
	public String redirect2() {
		
		return "addpage";
	}
	
	@RequestMapping(value = "/add")
	public String redirect3(@ModelAttribute("product")Product prod) {
		System.out.println(prod.getName() + " " + prod.getPrice());
		ProductDB.setup();
		ProductDB.addProduct(prod.getName(),prod.getPrice());
		
		ProductDB.close();
		return "index";
	}
	
	@RequestMapping(value = "/addcust")
	public String addcust(@ModelAttribute("customer")Customer cust) {
		Client client = ClientBuilder.newClient();
		String REST_URI = "http://localhost:8081/demo/cust";
		System.out.println(cust.getName() + " " + cust.getProductId());
		Customer c = new Customer(cust.getName(),cust.getProductId());
		client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(c, MediaType.APPLICATION_JSON));
		
		return "index";
	}
	
	@RequestMapping(value = "/updatecust")
	public String updatecust(@ModelAttribute("customer")Customer cust) {
		Client client = ClientBuilder.newClient();
		String REST_URI = "http://localhost:8081/demo/cust";
		System.out.println(cust.getId() + " " + cust.getName() + " " + cust.getProductId());
		Customer c = new Customer(cust.getName(),cust.getProductId());
		c.setId(cust.getId());
		client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(c, MediaType.APPLICATION_JSON));
		
		return "index";
	}
	
	@RequestMapping(value = "/deletecust")
	public String deletecust(@RequestParam int id) {
		Client client = ClientBuilder.newClient();
		String REST_URI = "http://localhost:8081/demo/cust/"+id;
		System.out.println(REST_URI);
		client.target(REST_URI).request().delete();
		
		return "index";
	}
	
	@RequestMapping(value = "/deleteall")
	public String deletecust() {
		Client client = ClientBuilder.newClient();
		String REST_URI = "http://localhost:8081/demo/cust/";
		System.out.println(REST_URI);
		client.target(REST_URI).request().delete();
		
		return "index";
	}
	
}
