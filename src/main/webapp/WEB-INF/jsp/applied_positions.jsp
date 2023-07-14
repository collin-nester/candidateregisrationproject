<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applied Positions</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Applied Positions</h2>
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
<p>Name: ${applicant.name}</p>
<a href="applied_positions_lookup">Applied Positions Lookup</a>
<p>Total Positions Applied For: ${total_applied}</p>

<table>
    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position ID</th>
    </tr>
    <c:forEach items="${applied_positions}" var="position">
        <tr>
                <td>${position.positionName}</td>
                <td>${position.positionDescription}</td>
                <td>${position.id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>