<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Logged in!! </p>
<p>

<h1>List of Employees</h1>
	<table border = "1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.ename}</td>
				<td>${e.dept}</td>
				<td>
					<a href = "/empget/?id=${e.id}">Edit</a>
					|
					<a href = "/delete/${e.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href='/showEmployeeForm'">Add Employee</button>
	<p>Logout?<a href="https://localhost10.auth.ap-south-1.amazoncognito.com/logout?client_id=7n6rm06r63t0uh3pnb6cc4916s&logout_uri=http://localhost:8080/logout">Logout</a></p>
</body>
</html>