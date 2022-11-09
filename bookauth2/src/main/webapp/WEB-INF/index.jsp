<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

	<title>hello world</title>

</head>

<body>
<table>
<tr><td>Books</td><td>Authors</td></tr>
<tr><td>
<ul>
       
        <c:forEach var="book" items="${books}">
        <li><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></li>
    	</c:forEach>
   
</ul>
</td>
<td>
<ul>
       
        <c:forEach var="auth" items="${authors}">
        <li><a href="/authors/${auth.id}"><c:out value="${auth.firstName}"></c:out> <c:out value="${auth.lastName}"></c:out></a></li>
    	</c:forEach>
   
</ul>
</td>
</tr>
</table>
</body>
</html>