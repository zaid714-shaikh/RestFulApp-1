<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String str =(String) request.getAttribute("msg");%>
<%if(str!=null) {%>
<h3 style="color: red"><%out.print(str); %></h3>
<%} %>

	<form action="log">

		Student-name:<input type="text" name="sname"> 
		Student-address<input type="text" name="saddress">
		<button value="submit">Submit</button>
	</form>
</body>
</html>