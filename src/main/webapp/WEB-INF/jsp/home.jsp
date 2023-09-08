<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Home</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
    <a href="notifications"><li>
        <c:if test="${hasNotifications}">
            <svg id="bell_circle" height="8" width="8">
                <circle cx="4" cy="4" r="4" fill="red"/>
            </svg>
        </c:if>
        <img src="../images/bell.png" height="20px" id="bell">
    </li>
    </a>
</ul>
</body>
</html>