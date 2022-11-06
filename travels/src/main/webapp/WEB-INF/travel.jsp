<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Travel details</h1>
<h2><c:out value="${singletravel.expense}"></c:out></h2>
<h2><c:out value="${singletravel.vendor}"></c:out></h2>
<h2><c:out value="${singletravel.price}"></c:out></h2>
<h2><c:out value="${singletravel.description}"></c:out></h2>

	<script type="text/javascript" src=""></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>