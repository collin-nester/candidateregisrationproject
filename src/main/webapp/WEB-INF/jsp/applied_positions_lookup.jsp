<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Applied Positions</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
    <h2>List Applied Positions</h2>
    <ul class="menubar">
        <a href="home"> <li>Home</li> </a>
        <a href="register"> <li>Register</li> </a>
        <a href="position_application"> <li>Position Application</li> </a>
        <a href="applied_positions"> <li>Applied Positions</li> </a>
        <a href="admin_tools"> <li>Admin Tools</li> </a>
        <a href="login"> <li>Login</li> </a>
        <a href="logout"> <li>Logout</li> </a>
    </ul>
    <form:form action="applied_positions_lookup" method="post" modelAttribute="application_info">
        Your ID: <form:input path="candidateId" type="number" min="1" id="candidateId" /> <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>