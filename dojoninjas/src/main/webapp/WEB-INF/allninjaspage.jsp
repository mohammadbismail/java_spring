<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
<h1>All Ninjas page</h1>
<h2><a href="/">Home</a></h2>
<h2><c:out value="${dojoFromDB.name}"></c:out></h2>
<table>
<thead>
<tr>
<td>First Name</td>
<td>Last Name</td>
<td>Age</td>
</tr>
<tbody>
<c:forEach var="singleninja" items="${dojoFromDB.getNinjas()}">
<tr>
<td><c:out value="${singleninja.firstName}"></c:out></td>
<td><c:out value="${singleninja.lastName}"></c:out></td>
<td><c:out value="${singleninja.age}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</thead>
</table>
<table>
</table>
</body>
</html>