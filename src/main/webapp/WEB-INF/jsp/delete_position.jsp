<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Position</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Delete Position</h2>
<mytags:navbar/>

Position ${position.positionName} (ID #${position.id}) has been deleted, along with ${deleted_applications.size()} applications for it.

</body>
</html>