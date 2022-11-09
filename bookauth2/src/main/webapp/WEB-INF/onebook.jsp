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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Title: ${book.title }</p>
<p>Description: ${book.description }</p>

        <c:forEach var="au" items="${book.authors}">
        <p><c:out value="${au.firstName}"></c:out><c:out value="${au.lastName}"></c:out></p>
    	</c:forEach>
    	
    	
 <form:form action="/books/addauth" method="post" modelAttribute="ba">  
 <form:input type="hidden" path="book" value="${book.id}"/>	
  <form:select path="author">
        <c:forEach var="auth" items="${authors}">
        <form:option value="${auth.id}"><c:out value="${auth.firstName}"></c:out></form:option>
    	</c:forEach>
        </form:select>
        <input type="submit" value="Send">
</form:form>
</body>
</html>