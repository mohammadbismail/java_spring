<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row m-5 justify-content-start ">
			<div class="col-2">
				<label for="gold">Your gold is</label> <input type="text"
					name="gold" value="<c:out value="${gold}"></c:out>">
			</div>
		</div>
		<div class="row col-10 m-4 justify-content-center">
			<div class="col-2 border border-2 border-opacity-25 py-2 mx-2">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<a href="/findgold/">Find Gold!</a>
			</div>
			<div class="col-2 border border-2 border-opacity-25 py-2 mx-2">
				<h2>Cave</h2>
				<p>(earns 10-20 gold)</p>
				<a href="/findgold/">Find Gold!</a>
			</div>
			<div class="col-2 border border-2 border-opacity-25 py-2 mx-2">
				<h2>House</h2>
				<p>(earns 10-20 gold)</p>
				<a href="/findgold/">Find Gold!</a>
			</div>
			<div class="col-3 border border-2 border-opacity-25 py-2 mx-2">
				<h2>Quest</h2>
				<p>(earns/takes 0-50 gold)</p>
				<a href="/quest/">Find Gold!</a>
			</div>
		</div>
		<div class="row col-8 m-5 justify-content-center">
			<h2>Activities</h2>
			<div class="border border-2">
				<c:forEach var="message" items="${updates}">
					<p>
						<c:out value="${message}" />
					</p>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>