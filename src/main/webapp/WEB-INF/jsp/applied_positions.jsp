<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applied Positions</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    td, th {width: 20%;}
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
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
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
        <th class="smallTableColumn">Resume Upload</th>
        <th class="smallTableColumn">Delete Application</th>
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
            <td class="smallTableColumn">
                <a href="upload_resume?positionId=${application.position.id}">
                    <button>Upload</button>
                </a>
            </td>
            <td class="smallTableColumn">
                <a onclick="if (!(confirm('Confirm deletion?'))) return false" href="delete_application?positionId=${application.position.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>