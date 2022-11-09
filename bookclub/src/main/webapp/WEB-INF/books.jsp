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
<link rel="stylesheet" type="text/css" href="/css/dashboard.css/">
<title>Success Page</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>
				Welcome
				<c:out value="${loggedUser.username}"></c:out>
			</h1>
			<p>Books from everyone's shelves</p>
		</div>
		<div>
			<p>
				<a href="/logout/">Logout</a>
			</p>
				<p>
				<a href="/books/new/">+ Add to my shelf!</a>
				</p>
		</div>
	</div>
<table>
 <thead>
 <tr>
 <td>ID</td>
 <td>Title</td>
 <td>Author Name</td>
 <td>Posted By</td>
 </tr>
 </thead>
 <tbody>
 <c:forEach var="book" items="${allbooks}">
 <tr>
 <td><c:out value="${book.id}"></c:out></td>
 <td><a href="/books/${book.id}/"><c:out value="${book.title}"></c:out></a></td>
 <td><c:out value="${book.author}"></c:out></td>
 <td><c:out value="${book.user}"></c:out></td>
 </tr>
 </c:forEach>
 </tbody>
</table>
</body>
</html>