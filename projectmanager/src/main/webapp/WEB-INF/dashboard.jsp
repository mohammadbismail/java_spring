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
<link rel="stylesheet" type="text/css" href="/css/dashboard.css/">
<title>Success Page</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>
				Hello
				<c:out value="${loggedUser.firstname} ${loggedUser.lastname}"></c:out>
			</h1>
		</div>
		<div>
			<p>
				<a href="/logout">Logout</a>
			</p>
			<p>
				<a href="/projects/add">+ new project</a>
			</p>
		</div>
	</div>
	<h2>All projects</h2>
	<table>
		<thead>
			<tr>
				<td>Project</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${projectsNotMember}">
				<tr>
					<td><a href="/projects/${project.id}/"><c:out value="${project.title}"></c:out></a></td>
					<td>
					<c:out value="${project.teamLead.firstname} ${project.teamLead.lastname}"></c:out></td>
					<td>
					<td><c:out value="${project.dueDate}"></c:out></td>
					<td>
					<form action="/userJoinTeam" method="post">
					<input type="hidden" name="project_id" value="${project.id}" />
					<input type="hidden" name="user_id" value="${loggedUser.id}" />
					<input type="submit" value="Join Team" />
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<h2>Your Projects</h2>
	<table>
		<thead>
			<tr>
				<td>Project</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${projectsMemberOrTL}">
				<tr>
					<td><a href="/projects/${project.id}/"><c:out value="${project.title}"></c:out></a></td>
					<td>
					<c:out value="${project.teamLead.firstname} ${project.teamLead.lastname}"></c:out></td>
					<td>
					<td><c:out value="${project.dueDate}"></c:out></td>
					<td>
					<td><c:set var="project" value="${project}" /> 
						<c:set var="user" value="${loggedUser}" /> 
						<c:if test="${loggedUser.id == project.teamLead.id }">
							<p><a href="/projects/edit/${project.id}/">Edit</a></p>
						</c:if>
						<c:if test="${loggedUser.id != project.teamLead.id}">
						<form action="/userLeaveTeam/" method="post">
						<input type="hidden" name="_method" value="put" />
						<input type="hidden" name="project_id" value="${project.id}" />
					<input type="hidden" name="user_id" value="${loggedUser.id}" />
								<input type="submit" value="Leave Team" />
							</form>
						</c:if>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
