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
		<input type="hidden" name="id" value="${client.id}">
		Name:<input type="text" name="name" value="${client.name}"><br>
		Address:<input type="text" name="address" value="${client.address}"><br>
		username:<input type="text" name="username" value="${client.username}"><br>
		password:<input type="password" name="password" value="${client.password}"><br>
		<input type="submit" value="update">
	</pre>
</form>
</body>
</html>