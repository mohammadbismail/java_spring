<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<body>
   <form:form action="/authors" method="post" modelAttribute="author">
    <p>
        <form:label path="firstName">firstName</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
        <p>
        <form:label path="lastName">lastName</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>  
</body>
</html>