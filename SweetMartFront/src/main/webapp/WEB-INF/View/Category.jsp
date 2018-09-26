<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%@ page isELIgnored="false" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg">

<div class="container text-center">

	<c:url value='/admin/addcategory' var="url"></c:url>
	
	<form:form modelAttribute="category" method="post" enctype="multipart/form-data" action="${url }">
		<table>
			<tr>
				<td></td>
				<!-- user need not give value for id, auto generation -->
				<td><form:hidden path="id"></form:hidden></td>
			</tr>
			<tr>
				<td><h3>Enter Category Name</h3>
				</td>
				<td><form:input path="categoryname"></form:input></td>
				
			</tr>
			
			<tr>
				<td><h3>Enter Price</h3>
				</td>
				<td><form:input path="price"></form:input></td>
				
			</tr>
			
			<tr>
				<td><h3>Enter Quantity</h3>
				</td>
				<td><form:input path="quantity"></form:input></td>
				
			</tr>
			
			
			<tr>
			<td><h3>Enter Category Description</h3></td>
			<td><form:textarea path="cdesc"></form:textarea></td></tr>
			
			<tr><td><h3>Upload image</h3></td><td> 
			<form:input path="image" type= "file"/> 
			</td></tr> 
			<td></td>
			<tr>
			<td><input type="submit" value="Add category" ></td>
			</tr>

		</table>
	</form:form>
	</div>
	</body>
</html>



