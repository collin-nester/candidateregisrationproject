<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Registerees</title>
    <style>
    table, td, th {border: 1px solid black; border-collapse: collapse; padding: 5px;}
    div.pos_selection {position: absolute; top: 20px; margin: 5px 0px 0px 50%; border: 1px solid black; padding: 10px; }
    #position_description_data {width: 20%;}
    #position_name_data {width: 10%;}
    #position_id_data {width: 10%;}
    #position_select_button_data {width: 5%;}
    table#position_table {width: 45%;}
    form:input {margin: 5px;}
    </style>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h2>List Registerees</h2>

<table id="position_table">

    <tr>
        <th>Position Name</th>
        <th>Position Description</th>
        <th>Position ID</th>
    </tr>

    <c:forEach items="${activePositions}" var="activePos">
        <tr>
                <td id="position_name_data">${activePos.positionName}</td>
                <td id="position_description_data">${activePos.positionDescription}</td>
                <td id="position_id_data">${activePos.id}</td>
                <td id="position_select_button_data" onclick="getElementById('posid').value=${activePos.id}; getElementById('submit').click();"><button>View List</button></td>
        </tr>
    </c:forEach>

</table>

<div class="pos_selection">
    <form:form action="list_registrees" method="post" modelAttribute="posinfo">
        Position ID: <form:input type="number" min="1" max="${max_pos_id}" id="posid" path="posid"/> <br>
        <input type="submit" id="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>