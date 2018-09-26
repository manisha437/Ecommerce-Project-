<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <style>
body {
    background-image: url("/resources/images/BackG.jpg");
}
</style>
 -->
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"">
<title>Insert title here</title>
   <link href="/resources/css/backgroundImg.css"  rel="stylesheet">
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg);" >
 <br><br><br><br> 
<div class="container">
	<c:url value='/admin/addproduct' var="url"></c:url>
	
	<form:form modelAttribute="product" method="post" enctype="multipart/form-data" action="${url }">
		<table>
			<tr>
				<td></td>
				<!-- user need not give value for id, auto generation -->
				<td><form:hidden path="id"></form:hidden></td>
			</tr>
			<tr>
				<td>Enter Product Name
				</td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
			<td>Enter Product Description</td>
			<td><form:textarea path="desc"></form:textarea></td></tr>
			<tr>
			<td>Enter Price</td>
			<td><form:input path="price"></form:input></td></tr>
			
			<tr><td>Enter Quantity</td>
			<td><form:input path="quantity"></form:input></td></tr>
			
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
			<form:input path="image" type= "file"/> 
			</td></tr> 
			
			<!-- div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
  </div>
  <div class="custom-file">
    <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
  </div>
</div> -->

			<tr>
			<td></td>
			<td><input type="submit" value="Add Product"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>


