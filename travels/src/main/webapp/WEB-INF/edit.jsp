<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="/expenses/">Go back</a></p>	
	<div>
<h2>Add an Expense</h2>
<form:form action="/expenses/edit/${travel.getId()}/" method="post" modelAttribute="travel">
	<input type="hidden" name="_method" value="put">
	<div>
	<form:errors path="expense"></form:errors>
	<form:label path="expense">Expense Name</form:label>
	<form:input  path="expense"></form:input>
	</div>
	<div>
	<form:errors path="vendor"></form:errors>
	<form:label path="vendor">Vendor</form:label>
	<form:input path="vendor"></form:input>
	</div>
	<div>
	<form:errors path="price"></form:errors>
	<form:label path="price">Amount</form:label>
	<form:input type="number" path="price"></form:input>
	</div>
	<div>
	<form:errors path="description"></form:errors>
	<form:label path="description">Description</form:label>
	<form:textarea path="description"></form:textarea>
	</div>
	<input type="submit" value="Submit" />
</form:form>
	
	</div>
	<script type="text/javascript" src=""></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>