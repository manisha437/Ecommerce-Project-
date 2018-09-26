<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products here</title>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg);" >
	<div class="container" text-center>
		Product Details<br>
		<div class="panel-info">
			<div class="panel panel-heading">Product Details</div>
			<div class="panel panel-body">
			<c:url value='/cart/addtocart/${productObj.id}' var="url"></c:url>
			<form action="${url }" >
			<img src="<c:url value='/resources/images/${productObj.id}.png'></c:url>"><br>
			<b>Product Name:</b>${productObj.name }<br>
			<b>Product Desc:</b>${productObj.desc }<br>
			<b>Price:</b>${productObj.price }<br>
			<b>Quantity:</b>${productObj.quantity }<br>
			<b>Category:</b>${productObj.category.categoryname}<br>
			<security:authorize access="hasRole('ROLE_USER')">
			Enter Quantity:<input type="number" name="requestedQuantity">
			<button class="btn btn-primary btn-lg" type="submit"><span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</button>
			</security:authorize>
			<h6>Select the Category</h6> 
			
			<%-- <form:select path="category.id"><!-- FK column value 
 			<!-- value is to set the value for the path category.id -->
		    <c:forEach items="${categories }" var="c">
		    <form:option value="${c.id }">${c.categoryname }</form:option>
		    </c:forEach>
			</form:select> --%>
						</div>
		</div>
	</div>
	<a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
</body>
</html>
