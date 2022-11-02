<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	 <div class="container">
        <h1>Send an Omikuji!</h1>
        <div class="row col-10">
            <form action="/submit/" method="post">
                <div class="row col-8">
                    <div class="col-4 mb-3">
                        <label for="number" class="form-label">Pick any number from 5 to 25</label>
                        <input type="number" class="form-control" name="number">
                    </div>
                    <div class="col-4 mb-3">
                        <label for="city" class="form-label">Enter the name of any city</label>
                        <input type="text" class="form-control" name="city"></input>
                    </div>
                    <div class="col-4 mb-3">
                        <label for="name">Enter the name of any real person</label>
                        <input type="text" class="form-control" name="name" />
                    </div>
                </div>
                <div class="row col-10">
                    <div class="col-6 mb-3">
                        <label for="hobby">Enter hobby</label>
                        <input type="text" class="form-control" name="hobby" />
                    </div>
                    <div class="col-6 mb-3">
                        <label for="desc">Enter hobby</label>
                        <input type="text" class="form-control" name="desc" />
                    </div>
                </div>
                <div class="row col-1">
                    <input type="submit" value="Send" />
                </div>
            </form>
        </div>
    </div>

</body>
</html>