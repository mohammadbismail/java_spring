<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/index.css">
<title>HomePage</title>
</head>
<body>
	<h1>Home Page</h1>
	<p>
		<a href="/products/new/">New Product</a>
	</p>
	<p>
		<a href="/categories/new/">New Category</a>
	</p>
	<hr />
	<div class="container">
		<div class="cont-prod">
			<h2>Products</h2>
			<ul>
			<c:forEach var="product" items="${allproducts}">
			<li><a href="/products/${product.id}/"><c:out value="${product.name}"></c:out></a></li>
			</c:forEach>
			</ul>
		</div>
		<div class="cont-categ">
		<h2>Categories</h2>
		<ul>
			<c:forEach var="category" items="${allcategories}">
			<li><a href="/categories/${category.id}/"><c:out value="${category.name}"></c:out></a></li>
			</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>