<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
<form method = "post" action="delCustomer/{id}">
<h3>Enter Customer id: </h3><input type="text" name="id"><br/>
<button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
</form>
</body>
</html>