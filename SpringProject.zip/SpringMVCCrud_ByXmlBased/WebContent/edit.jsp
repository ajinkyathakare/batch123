<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
	<pre>
		<input type="hidden" name="id" value="${employee.id}">
		Name:<input typ="text" name="name" value="${employee.name}"><br>
		Address:<input typ="text" name="address" value="${employee.address}"><br>
		designation:<input typ="text" name="designation" value="${employee.designation}"><br>
		username:<input typ="text" name="username" value="${employee.username}"><br>
		password:<input typ="password" name="password" value="${employee.password}"><br>
		<input type="submit" value="update">
	</pre>
</form>
</body>
</html>