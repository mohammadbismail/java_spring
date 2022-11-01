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
	<h1>Fruits Store</h1>
	<table>
		<thead>
		<tr>
		<td>Price</td>
		<td>Name</td>
		</tr>
		</thead>
		<c:forEach var="item" items="${keyFruits}">
		<tr>
		<td><c:out value="${item.getName()}"/></td>
		<td><c:out value="${item.getPrice()}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>