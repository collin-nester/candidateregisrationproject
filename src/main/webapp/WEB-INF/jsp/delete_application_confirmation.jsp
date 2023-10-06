<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Delete Application Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<mytags:navbar/>

Your application for ${position.positionName} (ID #${position.id}) has been deleted<br>
<button onclick="window.history.back()">Go Back</button>
</body>
</html>