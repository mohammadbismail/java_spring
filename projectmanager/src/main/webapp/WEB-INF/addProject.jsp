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
<link rel="stylesheet" type="text/css" href="/css/addbook.css/">
<title>Create A Task</title>
</head>
<body>

<h1>Create A project</h1>
<form:form action="/projects/create" method="post" modelAttribute="project">
<form:input type="hidden" path="teamLead" value="${loggedUser.id}"></form:input>
<div>
<form:label path="title">Project Title</form:label>
<form:input type="text" path="title"></form:input>
<form:errors path="title"></form:errors>
</div>
<div>
<form:label path="description">Project Description</form:label>
<form:input type="text" path="description"></form:input>
<form:errors path="description"></form:errors>
</div>
<div>
<form:label path="dueDate">Author</form:label>
<form:input type="date" path="dueDate"></form:input>
<form:errors path="dueDate"></form:errors>
</div>
<input type="submit" value="Submit!" />
</form:form>
</body>
</html>