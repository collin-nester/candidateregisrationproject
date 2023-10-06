<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Resume Upload Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<mytags:navbar/>

You've successfully uploaded the resume "${original_filename}" for the position ${joined.position.positionName}.
<a href="applied_positions"><button>Go Back</button></a>
</body>
</html>