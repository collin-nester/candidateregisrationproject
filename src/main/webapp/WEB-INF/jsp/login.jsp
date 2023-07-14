<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Login</h2>
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
<c:if test="${param.error != null}">
    Invalid login.
</c:if>
<c:if test="${param.logout != null}">
    Logout Successful
</c:if>
<form:form method="post" action="login">
    <br>Username: <input type="text" name="username"/>
    <br>Password: <input type="password" name="password"/>
    <br><input type="submit" name="login" value="Login">
</form:form>

</body>
</html>