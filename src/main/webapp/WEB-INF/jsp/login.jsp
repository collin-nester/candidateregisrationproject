<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Login</h2>
<mytags:navbar/>

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