<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Applicant List</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td, th {width: 20%;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Applicant List</h2>
<mytags:navbar/>

<p>
    Position: ${position.positionName} <br>
    Description: ${position.positionDescription} <br>
    Total Applied: ${total_applied} <br>
</p>

<table>
    <tr>
        <th>Applicant Name</th>
        <th class="smallTableColumn">Applicant ID</th>
        <th>Relevant Experience</th>
        <th>Relevant Education</th>
        <th class="smallTableColumn">Download Resume</th>
    </tr>
    <c:forEach items="${applications}" var="application">
        <tr>
                <td>${application.candidate.name}</td>
                <td class="smallTableColumn">${application.candidate.id}</td>
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
</table>

<button onclick="window.history.back()">Go Back</button>

</body>
</html>