<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>You have visited <a href="/">local host</a> <c:out value="${count}"></c:out> times.</h1>
<a href="/">Home page</a>
<a href="/two/">Increment by 2 page</a>
<a href="/reset/">Reset counter</a>

</body>
</html>