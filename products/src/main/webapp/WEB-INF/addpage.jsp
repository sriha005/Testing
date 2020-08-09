<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.main.dao.ProductDB" %>
<%@ page import="com.main.product.Product" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ page import = "com.main.dao.Setup" %>
<%@ page import="com.main.Customer" %>


<form:form action="add" method="post" modelAttribute = "product">  
Name:<input type="text" name="name"><br>  
Price:<input type="text" name="price"><br>  
<input type="submit" value="add product"> 
</form:form>

<form:form action="deletecust" method="delete" modelAttribute = "customer"> 
ID:<input type="number" name="id"><br>  
<input type="submit" value="delete customer"> 
</form:form>

<form:form action="deleteall" method="delete" modelAttribute = "customer"> 
 
<input type="submit" value="delete all customers"> 
</form:form>

<form:form action="updatecust" method="put" modelAttribute = "customer">  
Id:<input type="text" name="Id"><br> 
Name:<input type="text" name="name"><br>  
ProductId:<input type="number" name="productId"><br>  
<input type="submit" value="update customer"> 
</form:form>

<form:form action="addcust" method="post" modelAttribute = "customer">  
Name:<input type="text" name="name"><br>  
ProductId:<input type="number" name="productId"><br>  
<input type="submit" value="add customer"> 
<%
//ProductDB.setup();
//ProductDB.addProduct(request.getParameter("name"),Double.parseDouble(request.getParameter("price"))); 
//ProductDB.close();
//System.out.println(request.getParameter("name"));
%> 
</form:form>