<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applied Positions List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Applied Positions List</h2>
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
<p>${applicant.name}</p>
<p>Total Applied: ${total_applied}</p>

<table>
    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position ID</th>
        <th>Relevant Education</th>
        <th>Relevant Experience</th>
    </tr>
    <c:forEach items="${applications}" var="application">
        <tr>
                <td>${application.position.positionName}</td>
                <td>${application.position.positionDescription}</td>
                <td>${application.position.id}</td>
                <td>${application.education}</td>
                <td>${application.experience}
        </tr>
    </c:forEach>
    <button onclick="window.history.back()">Go Back</button>
</table>
</body>
</html>