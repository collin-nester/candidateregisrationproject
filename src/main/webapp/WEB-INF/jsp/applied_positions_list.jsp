<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applied Positions List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td, th {width: 15%;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Applied Positions List</h2>
<mytags:navbar/>

<p>
Name: ${applicant.name} <br>
ID: ${applicant.id}
</p>
<p>Total Positions Applied For: ${total_applied}</p>

<table>
    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th class="smallTableColumn">Position ID</th>
        <th>Relevant Education</th>
        <th>Relevant Experience</th>
        <th class="smallTableColumn">Resume Download</th>
    </tr>
    <c:forEach items="${applications}" var="application">
        <tr>
            <td>${application.position.positionName}</td>
            <td>${application.position.positionDescription}</td>
            <td class="smallTableColumn">${application.position.id}</td>
            <td>${application.education}</td>
            <td>${application.experience}</td>
            <td class="smallTableColumn">
                <c:if test="${application.resume != null}">
                    <a href="resumes/${application.candidate.id}+${application.position.id}" target="_blank">
                        <button>Download</button>
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    <button onclick="window.history.back()">Go Back</button>
</table>
</body>
</html>