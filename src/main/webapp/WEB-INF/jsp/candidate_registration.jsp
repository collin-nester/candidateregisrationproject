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
    <a href="create_position"> <li>Create Position</li> </a>
    <a href="list_applicants"> <li>List Applicants</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
<form:form action="register" method="post" modelAttribute="candidate">
    Name: <form:input type="text" path="name"/><br>
    Username: <form:input type="text" path="username"/><br>
    Password: <form:input type="password" path="password"/><br>
    Email: <form:input type="text" path="email"/><br>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>