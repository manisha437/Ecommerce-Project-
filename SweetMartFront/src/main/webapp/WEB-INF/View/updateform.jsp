<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg);" >
<div class="container">
<c:url value="/admin/updateproduct" var="url"></c:url>
<form:form modelAttribute="product" method="post" enctype="multipart/form-data" action="${url}">
		<table>
			<tr>
				<td></td>
				<!-- user need not
				 give value for id, auto generation -->
				<td><form:hidden path="id"></form:hidden></td>
			</tr>
			<tr>
				<td>Enter Product Name
				</td>
				<td><form:input path="name"></form:input><form:errors path="name" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
			<td>Enter Product Description</td>
			<td><form:textarea path="desc"></form:textarea><form:errors path="desc" cssStyle="color:red"></form:errors></td></tr>
			<tr>
			<td>Enter Price</td>
			<td><form:input path="price"></form:input><form:errors path="price" cssStyle="color:red"></form:errors>
			</td></tr>
			<tr><td>Enter Quantity</td>
			<td><form:input path="quantity"></form:input><form:errors path="quantity" cssStyle="color:red"></form:errors></td></tr>
<tr><td>Select the Category</td> 
			
			<td><form:select path="category.id"><!-- FK column value 
 			<!-- value is to set the value for the path category.id -->
		    <c:forEach items="${categories }" var="c">
		    <form:option value="${c.id }">${c.categoryname }</form:option>
		    </c:forEach>
			</form:select></td></tr>
			<tr> 
			<td></td>
<tr><td>Upload image</td><td>
			<form:input path="image" type="file"/>
			</td></tr>
		<tr>
			<td></td>	
	<td>		<input type="submit" value="updateproduct">
		

</td>
</tr>
		</table>

	</form:form>
</div>
</body>
</html>

