<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Applied Positions</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
    <h2>List Applied Positions</h2>
    <mytags:navbar/>

    <form:form action="applied_positions_lookup" method="post" modelAttribute="application_info">
        Your ID: <form:input path="candidateId" type="number" min="1" id="candidateId" /> <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>