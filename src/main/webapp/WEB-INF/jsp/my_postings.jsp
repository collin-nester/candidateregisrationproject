<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Postings</title>
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
        <th>Position ID</th>
        <th style="width: 10%;">Total Applicants</th>
    </tr>

    <c:forEach items="${created_positions}" var="position">
        <tr>
                <td id="position_name_data">${position.positionName}</td>
                <td id="position_description_data">${position.positionDescription}</td>
                <td id="position_id_data">${position.id}</td>
                <td style="width: 10%;">${position.candidateList.size()}</td>
                <td id="position_select_button_data" onclick="getElementById('posid').value=${position.id}; getElementById('submit').click();"><button>View Applicants</button></td>
                <td id="position_select_button_data" onclick="if (!(confirm('Confirm deletion?'))) return false; getElementById('delete_posid').value=${position.id}; getElementById('delete_submit').click();"><button>Delete Position</button></td>
        </tr>
    </c:forEach>

</table>

<div class="pos_selection">
    <form:form action="list_applicants" method="post" modelAttribute="posinfo">
        Go To Position ID: <form:input type="number" min="1" max="${max_pos_id}" id="posid" path="positionId"/> <br>
        <input type="submit" id="submit" value="Submit"/>
    </form:form>
</div>

<div class="pos_selection" style="margin-top: 100px;">
    <form:form action="delete_position" method="post" modelAttribute="posinfo">
        Delete Position ID: <form:input type="number" min="1" max="${max_pos_id}" id="delete_posid" path="positionId"/> <br>
        <input type="submit" id="delete_submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>