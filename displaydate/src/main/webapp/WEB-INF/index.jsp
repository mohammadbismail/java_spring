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

	<h1>
		Customer Name:<c:out value="${fname}"></c:out>
	</h1>
	<h3>
		Item name:
		<c:out value="${item}"></c:out>
	</h3>
	<h3>
		Price: $
		<c:out value="${price}" ></c:out>
	</h3>
	<h4>
		Description:
		<c:out value="${desc}" ></c:out>
	</h4>
	<h4>
		Vendor:
		<c:out value="${vendor}" ></c:out>
	</h4>
</body>
</html>