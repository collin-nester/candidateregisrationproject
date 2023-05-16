<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registered Positions List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h2>Registered Positions List</h2>
<p>${registree.name}</p>
<p>Total Registered: ${total_registered}</p>

<table>
    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position ID</th>
    </tr>
    <c:forEach items="${registered_positions}" var="position">
        <tr>
                <td>${position.positionName}</td>
                <td>${position.positionDescription}</td>
                <td>${position.id}</td>
        </tr>
    </c:forEach>
    <button onclick="window.history.back()">Go Back</button>
</table>
</body>
</html>