<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.SBI.onlinepay.Entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Student s = (Student) request.getAttribute("singleStudent");%>
	<form action="up">
		<div class="form-group">
			<label for="exampleInputEmail1">ID</label> <input type="hidden"
				name="sid" value=<%=s.getSid()%>>

		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Student-name</label> <input
				type="text" name="sname" value=<%=s.getSname()%>>

		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Student-School-name</label> <input
				type="text" name="sschoolname" value=<%=s.getSschoolname()%>>

		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Student-address</label> <input
				type="text" name="saddress" value=<%=s.getSaddress()%>>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>