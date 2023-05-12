<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registeree List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h2>Registeree List</h2>

<p>Total Registered: ${total_registered}</p>

<table>
    <tr>
        <th>Registeree Name</th>
        <th>Registeree Username</th>
        <th>Registeree ID</th>
    </tr>
    <c:forEach items="${candidates}" var="candidate">
        <tr>
                <td id="registeree_name">${candidate.name}</td>
                <td id="registeree_username">${candidate.username}</td>
                <td id="registeree_id">${candidate.id}</td>
        </tr>
    </c:forEach>
</table>
<button onclick="window.history.back()">Go Back</button>
</body>
</html>