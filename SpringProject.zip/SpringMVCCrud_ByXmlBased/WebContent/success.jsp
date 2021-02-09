<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<script type="text/javascript">
	function editData()
	{
		alert("this fun is called");
		document.myform.action="edit";
		document.myform.submit();
		
	}
	function deleteData()
	{
		alert("this fun is called");
		document.myform.action="delete";
		document.myform.submit();
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myform">
	<table border="5" style="background:pink;" align="center">
		<thead>
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Designation</th>
				<th>Username</th>
				<th>password</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data}" var="e">
			<tr>
				<td><input type="radio" value="${e.id}" name="rd"></td>
				<td><c:out value="${e.id}"></c:out></td>
				<td><c:out value="${e.name}"></c:out></td>
				<td><c:out value="${e.address}"></c:out></td>
				<td><c:out value="${e.designation}"></c:out></td>
				<td><c:out value="${e.username}"></c:out></td>
				<td><c:out value="${e.password}"></c:out></td>
				<td><input type="button" value="Edit" onclick="editData()"></td>
				<td><input type="button" value="Delete" onclick="deleteData()"></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>