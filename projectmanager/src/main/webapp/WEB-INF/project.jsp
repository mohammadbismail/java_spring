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
<h1>Project Details</h1>
<p><a href="/dashboard">Back to dashboard</a></p>
</header>
<h2>${projectToShow.title}</h2>
<h2>${projectToShow.description}</h2>
<h2>${projectToShow.dueDate}</h2>
<p><a href="/tasks/${projectToShow.id}/">See tasks</a></p>
<c:set var="project" value="${projectToShow}"></c:set>
<c:set var="loggedUser" value="${loggedUser}"></c:set>
<c:if test="${loggedUser.id == project.teamLead.id}">
<form action="/projects/delete" method="post">
<input type="hidden" name="_method" value="delete"/>
<input type="hidden" name="projectid" value="${projectToShow.id}"/>
<input type="submit" value="Delete" />
</form>
</c:if>
</body>
</html>