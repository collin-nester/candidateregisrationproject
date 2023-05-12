<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Registered Positions</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h2>List Registered Positions</h2>

    <form:form action="list_registered_positions" method="post" modelAttribute="registration_info">
        Your ID: <form:input path="applicantid" type="number" min="1" id="applicantid" /> <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>