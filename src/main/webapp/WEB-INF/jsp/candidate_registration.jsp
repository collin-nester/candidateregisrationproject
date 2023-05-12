<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Register</title>
<style>
input { margin: 3px;}
</style>
</head>
<body>
<h2>Register</h2>
<form:form action="register" method="post" modelAttribute="candidate">
    Name: <form:input type="text" path="name"/><br>
    Username: <form:input type="text" path="username"/><br>
    Password: <form:input type="password" path="password"/><br>
    Email: <form:input type="text" path="email"/><br>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>