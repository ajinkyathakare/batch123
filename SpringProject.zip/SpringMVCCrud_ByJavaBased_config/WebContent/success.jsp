<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<script type="text/javascript">
	function editData()
	{
		alert("edit fun called")
		document.myform.action="edit";
		document.myform.submit();
		
	}
	function deleteData()
	{
		alert("delete fun called")
		document.myform.action="delete";
		document.myform.submit();
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myform">
	<table border="5" align="center" style="background-color: silver;">
		<tr>
			<thead>
				<th>Select</th>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Username</th>
				<th>Password</th>
				<th>Edit</th>
				<th>Delete</th>
			</thead>
		</tr>
		<tbody>
			<c:forEach items="${data}" var="cl">
				<tr>
					<td><input type="radio" value="${cl.id}" name="rd"></td>
					<td><c:out value="${cl.id}"></c:out></td>
					<td><c:out value="${cl.name}"></c:out></td>
					<td><c:out value="${cl.address}"></c:out></td>
					<td><c:out value="${cl.username}"></c:out></td>
					<td><c:out value="${cl.password}"></c:out></td>
					<td><input type="button" value="edit" onclick="editData()"></td>
					<td><input type="button" value="delete" onclick="deleteData()"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="index.jsp">Back</a>
</form>
</body>
</html>