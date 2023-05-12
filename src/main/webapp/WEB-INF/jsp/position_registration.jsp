<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Position Registration</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    div.pos_registration {position: absolute; top: 20px; margin: 5px 0px 0px 50%; border: 1px solid black;
                          padding: 10px; }
    #position_description_data {width: 20%;}
    #position_name_data {width: 10%;}
    #position_id_data {width: 10%;}
    #position_register_button_data {width: 5%;}
    table#position_registration_table {width: 45%;}
    input {margin: 5px;}
    </style>
<link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h2>Position Registration</h2>
<table id="position_registration_table">
    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position ID</th>
    </tr>
    <c:forEach items="${allActivePositions}" var="activePos">
        <tr>
                <td id="position_name_data">${activePos.positionName}</td>
                <td id="position_description_data">${activePos.positionDescription}</td>
                <td id="position_id_data">${activePos.id}</td>
                <td id="position_register_button_data"><button onclick="getElementById('posid').value=${activePos.id}; getElementById('applicantid').focus();">Register</button></td>
        </tr>
    </c:forEach>
</table>

<div class="pos_registration">
    <form:form action="position_registration" method="post" modelAttribute="registration_info">
        Position ID: <form:input type="number" min="1" id="posid" path="posid"/> <br>
        Your ID: <form:input path="applicantid" type="number" min="1" id="applicantid" /> <br>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>