<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.main.dao.ProductDB" %>
<%@ page import="com.main.product.Product" %>

<%@ page import = "com.main.dao.Setup" %>
<%@ page import = "javax.ws.rs.core.GenericType" %>
<%@ page import = "javax.ws.rs.core.MediaType" %>
<%@ page import ="javax.ws.rs.client.Client"%>
<%@ page import = "javax.ws.rs.client.ClientBuilder" %>
<%@ page import = "com.main.Customer" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html> 
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body> 

<table style="width:100%">
<caption>Products</caption>
<thead>
	
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  </thead>
 <%// ProductDB.setup();
// ProductDB.getAllProducts(); %>
 <%// List<Product> list = ProductDB.getProducts(); %>
 <tbody>
<c:forEach var="emp" items="${list}">   
  <tr>
    <th> <% out.print(4); %> </th>
   <th> ${emp.getName()}</th>
   <th>${emp.getPrice()}</th>
   
    
  </tr>
  </c:forEach>  
  </tbody>
 <% 
	//ProductDB.close();
	%>
	
</table>
<table style="width:100%">
<caption>Customer Product Transaction</caption>
<thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>ProductId</th>
  </tr>
</thead>
  <!--  
	<%
	//Client client = ClientBuilder.newClient();
	// String REST_SERVICE_URL = "http://localhost:8080/demo/all";
	// GenericType<List<Customer>> list2 = new GenericType<List<Customer>>() {};
    // List<Customer> users = client
     //   .target(REST_SERVICE_URL)
      //  .request().accept(MediaType.APPLICATION_JSON)
      //  .get(list2);
%>
<%
	//for(Customer c:users) {%>
  <tr>
    <th> <%// out.print(4); %> </th>
   <th> <%//out.print(c.getName()); %></th>
   <th> <%//out.print(c.getProductId()); %></th>
  </tr>
  <%//} %>
  </table>
  -->
 <tbody>
  <c:forEach var="emp" items="${list2}">   
  <tr>
    <th> ${emp.getId()}  </th>
   <th> ${emp.getName()}</th>
   <th>${emp.getProductId()}</th>
   
    
  </tr>
  </c:forEach>  
</tbody>
</table>
<form action="index.jsp" method="get" target="_blank">
         <button type="submit">Go back</button>
 </form>

</body> 
</html>  