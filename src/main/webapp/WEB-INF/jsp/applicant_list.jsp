<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Applicant List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Applicant List</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
<p>
    Position: ${position.positionName} <br>
    Description: ${position.positionDescription} <br>
    Total Applied: ${total_applied} <br>
</p>

<table>
    <tr>
        <th>Applicant Name</th>
        <th>Applicant Username</th>
        <th>Applicant ID</th>
    </tr>
    <c:forEach items="${candidates}" var="candidate">
        <tr>
                <td id="applicant_name">${candidate.name}</td>
                <td id="applicant_username">${candidate.username}</td>
                <td id="applicant_id">${candidate.id}</td>
        </tr>
    </c:forEach>
</table>

<button onclick="window.history.back()">Go Back</button>

</body>
</html>