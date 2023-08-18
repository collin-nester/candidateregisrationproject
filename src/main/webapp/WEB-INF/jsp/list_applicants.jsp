<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Applicants</title>
    <style>
    #position_description_data {width: 20%;}
    #position_name_data {width: 10%;}
    #position_id_data {width: 10%;}
    #position_select_button_data {width: 5%;}
    table#position_table {width: 45%;}
    form:input {margin: 5px;}
    </style>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>List Applicants</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
<table id="position_table">

    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position Creator</th>
        <th>Position ID</th>
        <th style="width: 10%;">Total Applicants</th>
    </tr>

    <c:forEach items="${activePositions}" var="activePos">
        <tr>
                <td id="position_name_data">${activePos.positionName}</td>
                <td id="position_description_data">${activePos.positionDescription}</td>
                <td>${activePos.positionCreator.name}, ID #${activePos.positionCreator.id}</td>
                <td id="position_id_data">${activePos.id}</td>
                <td style="width: 10%;">${activePos.candidateList.size()}</td>
                <td id="position_select_button_data" onclick="getElementById('posid').value=${activePos.id}; getElementById('submit').click();"><button>View Applicants</button></td>
        </tr>
    </c:forEach>

</table>

<div class="pos_selection">
    <form:form action="list_applicants" method="post" modelAttribute="posinfo">
        Position ID: <form:input type="number" min="1" max="${max_pos_id}" id="posid" path="positionId"/> <br>
        <input type="submit" id="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>