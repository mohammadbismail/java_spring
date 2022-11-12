<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Road Share</title>
</head>
<body>
<header>
<h1>${bookFromDB.title}</h1>
<p><a href="/books/">Back to Shelf</a></p>
</header>
<c:set var="bookDB" value="${bookFromDB}"/>
<c:set var="userSession" value="${userFromSession}"/>
<c:if test="${bookDB.user.id == userSession.id}">
<p>You read, <c:out value="${bookDB.title}"/>by <c:out value="${bookDB.author}"/></p>
<p>Here are your thoughts</p>
<p><c:out value="${bookDB.thoughts}"/></p>
<a href="/books/edit/${bookFromDB.id}/">Edit</a>
<form action="/books/delete" method="post">
<input type="hidden" name="_method" value="delete"/>
<input type="hidden" name="bookid" value="${bookFromDB.id}"/>
<input type="submit" value="Delete" />
</form>
</c:if>
<c:if test="${bookDB.user.id != userSession.id}">
<p><c:out value="${userSession.username}"/> read, <c:out value="${bookDB.title}"/>by <c:out value="${bookDB.author}"/></p>
<p>Here are <c:out value="${bookDB.user.username}"/> thoughts</p>
<p><c:out value="${bookDB.thoughts}"/></p>
</c:if>
</body>
</html>