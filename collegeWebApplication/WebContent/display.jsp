<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<%
List<Employee> emps=(ArrayList)session.getAttribute("emps");

%>
<table border="5" class="table table-striped">
<tr> 
	<th>Employee ID</th> 
	<th>Employee Name</th> 
	<th>Employee City</th>
	<th>Employee Contact</th>
	<th>Employee Email</th>
	<th>Update</th>
	<th>Delete ID</th>
</tr>
<%for(Employee e:emps){%>
<tr>
	<td><%=e.getId() %></td>
	<td><%=e.getName() %></td>
	<td><%=e.getCity() %></td>
	<td><%=e.getContact() %></td>
	<td><%=e.getEmail() %></td>
	<td><a href="edit?id=<%=e.getId()%>"><button type="submit" class="btn btn-success">Update Employee</button></a></td>
	<td><a href="delete?id=<%=e.getId()%>"><button type="submit" class="btn btn-info">Delete Employee</button></a></td>
</tr>
	
<% } %>
</table>
<div class="form-row text-center">
   <div class="col-12">
   <a href="insert.jsp" class="btn btn-success">Insert Record</a>
   </div>
   </div>

</body>
</html>