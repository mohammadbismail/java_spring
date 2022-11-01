<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<div class="container">
	<h1>Send an Omikuji!</h1>
	<div class="row col-10">
	<form action="/submit/" method="post">
	<label for="number">Pick any number from 5 to 25</label>
	<input type="number" name="number"/>
	<label for="city">Enter the name of any city</label>
	<input type="text" name="city"/>
	<label for="name">Enter the name of any real person</label>
	<input type="text" name="name"/>
	<label for="hobby">Enter hobby</label>
	<input type="text" name="hoppy"/>
	<label for="desc">Say something</label>
	<input type="text" name="desc"/>
	<input type="submit" value="Send"/>
	</form>
	</div>
	</div>
</body>
</html>