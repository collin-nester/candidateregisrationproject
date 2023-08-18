<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Upload Resume</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
<form:form enctype="multipart/form-data" action="upload_resume?positionId=${position_id}" method="POST" modelAttribute="form_info_carrier">
    <form:input type="file" path="file"/> <br>
    <input type="submit" value="Upload"/>
</form:form>
</body>
</html>