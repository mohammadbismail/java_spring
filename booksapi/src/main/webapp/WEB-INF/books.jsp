<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A Book</title>
</head>
<body>
<table>
<thead>
<tr>
<td>ID</td>
<td>Title</td>
<td>Language</td>
<td>Number of pages</td>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}">
<tr>
<td><c:out value="${book.id}"/></td>

<td><a href="/book/${book.id}/"><c:out value="${book.title}"/></a></td>
<td><c:out value="${book.language}"/></td>
<td><c:out value="${book.numberOfPages}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>