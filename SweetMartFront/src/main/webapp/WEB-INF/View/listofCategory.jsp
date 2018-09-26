<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	var searchCondition='${searchCondition}'
	$('.table').DataTable({
		"lengthMenu":[[5,7,-1],[5,7,"All"]],
	    "oSearch" : {
		"sSearch" : searchCondition
		}
	})
})
</script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg">

	<div class="container">
		<b>List of Category</b>
		<table class="table table-striped" border="2">
			<thead>
				<tr>
					<th>Id</th>
					<th>Image</th>
					<th>Category Name</th>
  					<th>Category Desc</th>
				<th>Price</th>
					<th>Quantity</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cl" items="${CategoryList}">	
				<tr>
				<td><img src="<c:url value='/resources/images/${cl.id }.png'></c:url>" height="30px" width="30px"></td>

						<td>${cl.id }</td>
						<td>${cl.
						categoryname }</td>
				         <td>${cl.cdesc }</td> 
 					     <td>${cl.price }</td> 
						<td>${cl.quantity }</td>
						
							
											<td>
									 <security:authorize access="hasRole('ROLE_USER')">	
								<a href="<c:url value='/all/getcategory/${cl.id }'></c:url>"><img src="<c:url value='/resources/images/imagesinfo.jpg'></c:url>"></a> 
								</security:authorize>
								<security:authorize access="hasRole('ROLE_ADMIN')">
								<a href="<c:url value='/admin/updatecategory/${cl.id }'></c:url>"><img src="<c:url value='/resources/images/update11.jpg'></c:url>"></a>
 
								<a href="<c:url value='/admin/deletecategory/${cl.id }'></c:url>"><img src="<c:url value='/resources/images/download.jpg'></c:url>"></a>
							</security:authorize>
							
							</td>
							</tr>				
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
