<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<br>
<div class="panel-info">
<div class="panel panel-heading">Category Details</div>
<div class="panel panel-body"></div>
<c:url value='/cart/addtocart/${categoryObj.id}' var="url"></c:url>
			<form action="${url }" >
			<img src="<c:url value='/resources/images/${categoryObj.id}.png'></c:url>"><br>
<b>Category Name:</b>${categoryObj.categoryname }<br> 
<b>Category Desc:</b>${categoryObj.cdesc }<br> 
<b>Price:</b>${categoryObj.price }<br> 
<b>Quantity:</b>${categoryObj.quantity }<br> 
<!-- <button class="btn btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span></button> -->
</div>
</div>

<a href="<c:url value="/all/getallcategory"></body></c:url>">Show all products</a>
</body>
</html>