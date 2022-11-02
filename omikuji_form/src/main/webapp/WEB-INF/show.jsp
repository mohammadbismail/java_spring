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
	<h1>Here is your Omikuji!</h1>
	<div>
		<p>
			In
			<c:out value="${number}" />
			you will live in
			<c:out value="${city}" />
			with
			<c:out value="${name}" />
			as you roommate,
			<c:out value="${hobby}" />
			, you will have a good luck and
			<c:out value="${desc}" />
		</p>
	</div>
	<a href="/">Go back</a>
</body>
</html>