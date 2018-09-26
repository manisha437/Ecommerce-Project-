<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
<!-- JQuery -->
<!--     <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script> -->
<!--     <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script> -->


<!--     <link href="https://cdn.datatables.net/1.10.10/resources/css/jquery.dataTables.min.css" rel="stylesheet"> -->
<title>LOONI's SWEETMART</title>

</head>
<body> <%-- style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg);" --%> 
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
<%-- 				<a href="" class="navbar-brand"><img src="<c:url value='/resources/images/niit.jpg'></c:url>" alt="NIIT" height="30px" width="70px"></a> --%>
			<button type="button" class="navbar-toggle collapsed"  
			   data-toggle="collapse" data-target="#navbardemo" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
			</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<ul class="nav navbar-nav">
			    <li><a href="#"><b>LOONI's SWEETMART</b></a></li>
				<li><a href='<c:url value='/index'></c:url>' class="fontSize"><b>Home</b></a></li>
				<li><a href="<c:url value='/aboutus'></c:url>" ><b>About Us</b></a></li>
				<li><a href="<c:url value='/all/getallproducts'></c:url>"><b>Browse all products</b></a>
				<li>
				<li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><b></>Select By Category</b><span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<c:forEach items="${categories }" var="category">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${category.categoryname }'></c:url>">${category.categoryname }</a>
				</li>
				
				</c:forEach>
				<li>
				<a href="<c:url value='/all/getallcategory'></c:url>"><b>All</b></a>
				</li>
				</ul>
			   </li>
			  
			   <security:authorize access="hasRole('ROLE_ADMIN')">
			   <li><a href="<c:url value='/admin/getproductform'></c:url>"><b>Add Product</b></a></li>
			   <li><a href="<c:url value='/admin/getcategoryform'></c:url>"><b>Add Category</b></a></li>
			   
			   </security:authorize>
			   
			   <security:authorize access="hasRole('ROLE_USER')">
<!-- 			   <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li> -->
			   <a href="<c:url value='/cart/getcart'></c:url>"><img src="<c:url value='/resources/images/cart.png'></c:url>"></a>  
			   </security:authorize>
			   
			   <c:if test="${pageContext.request.userPrincipal.name==null }">
				<li><a href="<c:url value='/all/registrationform'></c:url>"><b>Sign Up</b></a></li>
				<li><a href="<c:url value='/login'></c:url>"><b>Sign In</b></a></li>
				</c:if>
				
				<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="/index"><b>Welcome ${pageContext.request.userPrincipal.name }</b></a></li>
				<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><b>Sign out</b></a></li>
			    </c:if>
			</ul>
			</div>
		</nav>
	</div>
</body>
</html>

