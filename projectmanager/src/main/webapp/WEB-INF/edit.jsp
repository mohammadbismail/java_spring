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
<title>Book Edit</title>
</head>
<body>
	<header>
		<h1>Edit project</h1>
		<p>
			<a href="/books/">Back to Dashboard</a>
		</p>
	</header>
	<form:form action="/projects/edit/${projectToEdit.id}" method="post" modelAttribute="projectToEdit">
		<input type="hidden" name="_method" value="put" />
		<form:input type="hidden" path="teamLead" value="${user.id}"/>
		 <input type="hidden" name="id" value="${projectToEdit.id}"/>
		<div>
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title"></form:input>
			<form:errors path="title"></form:errors>
		</div>
		<div>
			<form:label path="description">Project Description</form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description"></form:errors>
		</div>
		<div>
			<form:label path="dueDate">Due Date</form:label>
			<form:input type="date" path="dueDate"></form:input>
			<form:errors path="dueDate"></form:errors>
		</div>
		<input type="submit" value="Submit!" />

	</form:form>

</body>
</html>