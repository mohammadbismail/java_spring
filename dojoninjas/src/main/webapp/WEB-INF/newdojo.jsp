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
<h1>New Dojo</h1>
<h2><a href="/ninjas/new/">Go to add Ninja page</a></h2>
<form:form action="dojos/create" method="post" modelAttribute="dojo">

<div>
<form:errors path="name"></form:errors>
<form:label path="name">Name:</form:label>
<form:input type="text" path="name"></form:input>
</div>
<input type="submit" value="create" />
</form:form>
</body>
</html>