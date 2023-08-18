<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Create Position</title>
    <style>
    textarea {margin: 5px; padding: 5px;}
    textarea {font-family: sans-serif; width: 25%; height: 75px;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>

<body>
<h2>Create Position</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
    <form:form action="create_position" method="post" modelAttribute="new_position">
        Position Name:<br> <form:input type="text" path="positionName" required="true"/> <br>
        Position Description:<br> <form:textarea path="positionDescription" required="true"/> <br>
        <input type="submit" value="Create"/>
    </form:form>
</body>

</html>