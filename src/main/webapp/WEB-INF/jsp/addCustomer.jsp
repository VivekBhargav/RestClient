<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<title>New Customer</title>
</head>
<body>
<br/>
<br/>
<h2 align="center" style="color: green">Add Customer</h2>

	<form:form modelAttribute="customer" cssClass="form-horizontal"
		action="addCustomer" method="post">
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">Title: </label>
			<div class="col-sm-10">
				<form:input path="title" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">First Name: </label>
			<div class="col-sm-10">
				<form:input path="firstName" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastName" class="col-sm-2 control-label">Last Name: </label>
			<div class="col-sm-10">
				<form:input path="lastName" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email: </label>
			<div class="col-sm-10">
				<form:input path="email" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="company" class="col-sm-2 control-label">Company: </label>
			<div class="col-sm-10">
				<form:input path="company" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="displayName" class="col-sm-2 control-label">Display Name: </label>
			<div class="col-sm-10">
				<form:input path="displayName" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" align="middle" value="Add" class="btn btn-lg btn-primary" />
		</div>
	</div>
	</form:form>
</body>
</html>