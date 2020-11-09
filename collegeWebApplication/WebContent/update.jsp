<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<%Employee emptobUpdated=(Employee)session.getAttribute("empTobUpdate");; 
out.print(emptobUpdated);%>
<form action="update"  class="container bg-success">

<div class="form group">
<label for="id">Employee Id:</label>
<input type="text" id="id" name="id" class="form-control"  value="<%=emptobUpdated.getId() %>">
</div>

<div class="form group">
<label for="name">Employee Name:</label>
<input type="text" id="name" name="name" class="form-control" value="<%=emptobUpdated.getName() %>">
</div>

<div class="form group">
<label for="city">Employee City:</label>
<input type="text" id="city" name="city" class="form-control"  value="<%=emptobUpdated.getCity() %>">
</div>

<div class="form group">
<label for="contact">Employee Contact:</label>
<input type="text" id="contact" name="contact" class="form-control"  value="<%=emptobUpdated.getContact() %>">
</div>

<div class="form group">
<label for="email">Employee Email:</label>
<input type="text" id="email" name="email" class="form-control"  value="<%=emptobUpdated.getEmail() %>">
</div>

<br>
<button type="submit" class="btn btn-info">Update Employee</button>
</form>
</body>
</html>