<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/logreg.css/">
<meta charset="ISO-8859-1">
<title>Road Share</title>
</head>
<body>
	<h1>Book Club</h1>
	<h2>A place for friends to share thoughts on books</h2>
	<div class="reglog">
		<form:form action="/register/" method="post" modelAttribute="newUser">
			<h2>Register</h2>
			<div>
			<form:label path="username">User Name:</form:label>
			<form:input path="username"></form:input>
			<form:errors path="username"></form:errors>
		</div>
		<div>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email"></form:input>
			<form:errors path="email"></form:errors>
		</div>
		<div>
			<form:label path="password">Password:</form:label>
			<form:input type="password" path="password"></form:input>
			<form:errors path="password"></form:errors>
		</div>
		<div>
			<form:label path="confirm">Confirm Password:</form:label>
			<form:input type="password" path="confirm"></form:input>
			<form:errors path="confirm"></form:errors>
		</div>
		<input type="submit" value="Register" />
		</form:form>
		<form:form action="/login/" method="post" modelAttribute="newLogin">
			<h2>Log In</h2>
			<div>
				<form:label path="email">Email:</form:label>
				<form:input type="email" path="email"></form:input>
				<form:errors path="email"></form:errors>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"></form:input>
				<form:errors path="password"></form:errors>
			</div>
			<input type="submit" value="Login" />
		</form:form>
	</div>
</body>
</html>