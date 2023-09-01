<!DOCTYPE html>
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
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
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