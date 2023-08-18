<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Tools</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Admin Tools</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>

<ul>
    <li><a href="create_position">Create Position</a></li>
    <li><a href="list_applicants">List Applicants</a></li>
    <li><a href="applied_positions_lookup">Applied Positions Lookup</a></li>
    <li><a href="my_postings">My Postings</a></li>
</ul>

</body>
</html>