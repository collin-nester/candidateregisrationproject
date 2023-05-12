<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Create Position</title>
    <style>
    textarea {margin: 5px; padding: 5px;}
    textarea {font-family: sans-serif; width: 25%; height: 75px;}
    </style>
</head>

<body>
<h2>Create Position</h2>
    <form:form action="create_position" method="post" modelAttribute="new_position">
        Position Name:<br> <form:input type="text" path="positionName"/> <br>
        Position Description:<br> <form:textarea path="positionDescription"/> <br>
        <input type="submit" value="Create"/>
    </form:form>
</body>

</html>