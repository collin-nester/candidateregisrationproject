<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Upload Resume</h2>
<mytags:navbar/>

<form:form enctype="multipart/form-data" action="upload_resume?positionId=${position_id}" method="POST" modelAttribute="form_info_carrier">
    <form:input type="file" path="file"/> <br>
    <input type="submit" value="Upload"/>
</form:form>
</body>
</html>