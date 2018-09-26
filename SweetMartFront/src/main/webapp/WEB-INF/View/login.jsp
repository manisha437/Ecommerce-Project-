<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<!-- <style> -->
<!-- background-image:url("resources/images/BG1.png");}</style> -->

</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/images/BackG.jpg);" >
<span style="color:red">${error }</span><br>
${msg }<br>
  <!-- <form class="form-vertical" action="login" method="POST">
 -->  
 <c:url value="/j_spring_security_check" var="url"></c:url>
<form method="post" action="${url }">
  <div class="form-group"></div>
   <div class="col-sm-offset-2 col-sm-6">
    <label for="Username"  style="font-size:20px" style="font-family :Times New Roman" >ENTER USERNAME: </label><input type="text"    class="form-control" id="username" name="j_username"   placeholder="Enter Username" >

  </div>
  <div class="form-group"></div>
   <div class="col-sm-offset-2 col-sm-6">
    <label for="pwd" style="font-size:20px">ENTER PASSWORD:</label><input type="password" class="form-control" id="pwd" name="j_password"   placeholder="Enter Password" >
    
    </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-6">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  <div class="form-group" > </div>
    <div class="col-sm-offset-2 col-sm-6">
      <button  class="btn btn-default" style="font-size:22px"><b>LOGIN</b></button>
    </div>
  
  </form>
  </body>

</html>
