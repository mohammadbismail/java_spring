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
<h1>New Ninja</h1>
<h2><a href="/">Home</a></h2>
<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
<div>
<form:select path="dojo">
<c:forEach var="adojo" items="${dojosFromDB}">
	<option value="${adojo.id}"><c:out value="${adojo.name}"></c:out></option>
</c:forEach>
</form:select>
</div>
<div>
<form:errors path="firstName"></form:errors>
<form:label path="firstName">First Name:</form:label>
<form:input type="text" path="firstName"></form:input>
</div>
<div>
<form:errors path="lastName"></form:errors>
<form:label path="lastName">Last Name:</form:label>
<form:input type="text" path="lastName"></form:input>
</div>
<div>
<form:errors path="age"></form:errors>
<form:label path="age">Age:</form:label>
<form:input type="number" path="age"></form:input>
</div>
<input type="submit" value="Create Ninja" />
</form:form>
</body>
</html>