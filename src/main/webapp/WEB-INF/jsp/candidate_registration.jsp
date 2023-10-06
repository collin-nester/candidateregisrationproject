<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Register</title>
<style>
input { margin: 3px;}
</style>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Register</h2>
<mytags:navbar/>

<form:form action="register" method="post" modelAttribute="forminfocarrier">
    Name: <form:input type="text" path="candidate.name" required="true"/><br>
    Username: <form:input type="text" path="candidate.username" required="true"/><br>
    Password: <form:input type="password" path="candidate.password" required="true"/><br>
    Email: <form:input type="text" path="candidate.email" required="true"/><br>
    Admin <form:checkbox path="admin"/><br>
    Recieve email updates? <form:checkbox path="emailable"/><br>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>