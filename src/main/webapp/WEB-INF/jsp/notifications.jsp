<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notifications</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Notifications</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>

<c:choose>
    <c:when test="${notification.size() == 0}">
        You have no new notifications
    </c:when>
    <table>
        <tr>
            <th>Subject</th>
            <th>Message</th>
        </tr>
        <c:otherwise>
            <c:forEach items="${notifications}" var="notification">
                <tr>
                    <th>${notification.header}</th>
                    <td>${notification.body}</th>
            </c:forEach>
        </c:otherwise>
    </table>
</c:choose>

</body>
</html>