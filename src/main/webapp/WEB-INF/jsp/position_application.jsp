<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Position Application</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    div.pos_application {position: absolute; top: 20px; margin: 5px 0px 0px 50%; border: 1px solid black;
                          padding: 10px; }
    #position_description_data {width: 20%;}
    #position_name_data {width: 10%;}
    #position_id_data {width: 10%;}
    #position_apply_button_data {width: 5%;}
    table#position_application_table {width: 45%;}
    input {margin: 5px;}
    textarea {width: 300px; height: 150px;}
    </style>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Position Application</h2>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>

<table id="position_application_table">
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
            <td id="position_apply_button_data"><button onclick="getElementById('posid').value=${activePos.id}; getElementById('education').focus();">Apply</button></td>
        </tr>
    </c:forEach>
</table>

<div class="pos_application">
    <form:form enctype='multipart/form-data' action="position_application" method="post" modelAttribute="application_info">
        Position ID: <br><form:input type="number" min="1" id="posid" path="positionId" required="true"/> <br>
        Relevant Education: <br><form:textarea id="education" path="education" required="true"/> <br>
        Relevant Experience: <br><form:textarea id="experience" path="experience" required="true"/> <br>
        Resume: <form:input type="file" name="file" path="file"/> <br>
        <input type="submit" value="Submit" id="submit"/>
    </form:form>
</div>
</body>
</html>