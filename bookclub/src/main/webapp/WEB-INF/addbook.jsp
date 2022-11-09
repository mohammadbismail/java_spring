<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/addbook.css/">
<title>Book Share</title>
</head>
<body>
<header>
<h1>Add book to your shelf!</h1>
<p><a href="/books/">Back to Shelf</a></p>
</header>
<form:form action="/books/create" method="post" modelAttribute="book">
<div>
<form:errors path="title"></form:errors>
<form:label path="title">Title</form:label>
<form:input type="text" path="title"></form:input>
</div>
<div>
<form:errors path="author"></form:errors>
<form:label path="author">Author</form:label>
<form:input type="text" path="author"></form:input>
</div>
<div>
<form:errors path="thoughts"></form:errors>
<form:label path="thoughts">My Thoughts</form:label>
<form:textarea path="thoughts"></form:textarea>
</div>
<input type="submit" value="Submit!" />
</form:form>
</body>
</html>