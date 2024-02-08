<%@page import="com.SBI.onlinepay.Entity.Student"%>
<%@page import="java.util.List"%>
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
<form name="mypage">
	<%
		List<Student> sl = (List<Student>) request.getAttribute("slist");
	%>

	<table border="4" style="color: green">
		<thead>
			<tr>
				<th>SelectID</th>
				<th>ID</th>
				<th>Student-Name</th>
				<th>Student-Schoolname</th>
				<th>Student-Address</th>
				<th>EditSection</th>
				<th>DeleteSection</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
					for (Student s : sl) {
				%>
				<td><input type="radio" name="sid" value=<%=s.getSid() %>></td>
				<td><%=s.getSid()%></td>
				<td><%=s.getSname()%></td>
				<td><%=s.getSschoolname()%></td>
				<td><%=s.getSaddress()%></td>
				<td><button value="submit" onclick="Edit();">Edit</button></td>
				<td><button value="submit" onclick="deleteall();">delete</button></td>
				</tr>
				<%
					}
				%>
			
		</tbody>
	</table>
	
	<script type="text/javascript">
	
	function Edit() {
		alert()
		document.mypage.action="edit";
		document.mypage.submit();
		
	}
	
	function deleteall() {
		alert()
		document.mypage.action="del";
		document.mypage.submit();
		
	}
	</script>
	</form>
</body>
</html>